package org.dezzzl.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dezzzl.exception.DatabaseException;
import org.dezzzl.model.Player;
import org.dezzzl.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerRepository implements Repository<Integer, Player> {

    private static final PlayerRepository INSTANCE = new PlayerRepository();

    public static PlayerRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Player save(Player player) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(player);
            session.getTransaction().commit();
            return player;
        }
    }

    public Optional<Player> findByName(String name) {
        try (Session session  = HibernateUtil.buildSessionFactory().openSession()){
            session.beginTransaction();
            Optional<Player> player = Optional.
                    ofNullable(session.createQuery("select p from Player p " +
                                                   "where p.name = :name", Player.class)
                            .setParameter("name", name)
                            .uniqueResult());
            session.getTransaction().commit();
            return player;
        } catch (HibernateException e) {
            throw new DatabaseException();
        }
    }
}
