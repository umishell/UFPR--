package model.connection;

public class DaoFactory {

    private DaoFactory() {
    }

    public static ClienteDaoSql getClienteDao(DaoType type) {
        switch (type) {
            case SQL:
                return ClienteDaoSql.getClienteDaoSql();
            case INMEMORY:
                return ClienteDaoSql.getClienteDaoSql();//ClienteDaoInMemory.getClienteDaoInMemory();
            default:
                throw new RuntimeException("Tipo não existe:" + type);
        }
    }

}
