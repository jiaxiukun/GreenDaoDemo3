package baway.com.greendaodemo3.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import baway.com.greendaodemo3.entity.Been;

import baway.com.greendaodemo3.gen.BeenDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig beenDaoConfig;

    private final BeenDao beenDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        beenDaoConfig = daoConfigMap.get(BeenDao.class).clone();
        beenDaoConfig.initIdentityScope(type);

        beenDao = new BeenDao(beenDaoConfig, this);

        registerDao(Been.class, beenDao);
    }
    
    public void clear() {
        beenDaoConfig.clearIdentityScope();
    }

    public BeenDao getBeenDao() {
        return beenDao;
    }

}
