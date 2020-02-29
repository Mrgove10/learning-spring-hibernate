package org.epsi.b3.simplewebapp.db.utils;

import org.epsi.b3.simplewebapp.HibernateUtil;
import org.epsi.b3.simplewebapp.products.Product;
import org.epsi.b3.simplewebapp.users.Gender;
import org.epsi.b3.simplewebapp.users.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DBUtils {

    public static UserAccount findUser(
            /*Connection conn,*/
            String userName,
            String password
    ) {
        /*Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        String sql = "Select a.idUser, a.userName, a.password, a.gender from USER_ACCOUNT a " //
                + " where a.userName = ? and a.password= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setIdUser(rs.getInt("idUser"));
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(Gender.values()[rs.getInt("gender")]);
            return user;
        }
        return null;*/
        UserAccount p;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(UserAccount.class);
            p = (UserAccount) criteria
                    .add(Restrictions.eq("userName", userName))
                    .add(Restrictions.eq("password", password))
                    .uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
        return p;
    }

    public static UserAccount findUser(/*Connection conn,*/ String userName) {
      /*  String sql = "Select a.idUser, a.userName, a.password, a.gender from USER_ACCOUNT a "//
                + " where a.userName = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            int idUser = rs.getInt("idUser");
            String password = rs.getString("password");
            UserAccount user = new UserAccount();
            user.setIdUser(idUser);
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(Gender.values()[rs.getInt("gender")]);
            return user;
        }
        return null;*/

        UserAccount p;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(UserAccount.class);
            p = (UserAccount) criteria.add(Restrictions.eq("userName", userName)).uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
        return p;
    }

    public static List<Product> queryProduct(/*Connection conn*/) {
        /*String sql = "Select a.code, a.name, a.price from PRODUCT a ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("code");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);
        }
        return list;*/

        List<Product> products;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            //Get Criteria Builder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            //Create Criteria
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            Root<Product> productRoot = criteria.from(Product.class);
            criteria.select(productRoot);

            //Use criteria to query with session to fetch all contacts
            products = session.createQuery(criteria).getResultList();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
        return products;
    }

    public static Product findProduct(/*Connection conn,*/ String code) {
       /* String sql = "Select a.code, a.name, a.price from PRODUCT a where a.code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;*/

        Product p;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            p = session.get(Product.class, code);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
        return p;
    }

    public static void updateProduct(/*Connection conn,*/ Product product) {
       /* String sql = "Update PRODUCT set name =?, price=? where code=? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
    }

    public static void insertProduct(/*Connection conn,*/ Product product) {
        /*String sql = "Insert into PRODUCT(code, name,price) values (?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
        pstm.executeUpdate();*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
    }

    public static void deleteProduct(/*Connection conn,*/ String code) {
       /* String sql = "Delete From PRODUCT where code= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        pstm.executeUpdate();*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(findProduct(code));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            HibernateUtil.shutdown();
        }
    }

}
