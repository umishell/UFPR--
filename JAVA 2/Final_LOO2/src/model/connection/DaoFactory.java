package model.connection;

public class DaoFactory {

    private DaoFactory() {
    }

    public static ClienteDaoSql getAlunoDao(DaoType type) {
        switch (type) {
            case SQL:
                return ClienteDaoSql.getClienteDaoSql();
            case INMEMORY:
                return ClienteDaoInMemory.getClienteDaoInMemory();
            default:
                throw new RuntimeException("Tipo não existe:" + type);
        }
    }

}
