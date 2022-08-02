package ru.voronov.jdbc.mapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Aleksandr Voronov
 */
public class EntitySQLMetaDataImpl implements EntitySQLMetaData{

    private final EntityClassMetaData entityClassMetaData;

    public EntitySQLMetaDataImpl(EntityClassMetaData entityClassMetaData){
        this.entityClassMetaData = entityClassMetaData;
    }

    @Override
    public String getSelectAllSql() {
        return "select " +
                String.join(", ", entityClassMetaData.getAllFields()) +
                " from " +
                entityClassMetaData.getName();
    }

    @Override
    public String getSelectByIdSql() {
        return getSelectAllSql() +
                "where " +
                entityClassMetaData.getIdField() +
                " = ? ";
    }

    @Override
    public String getInsertSql() {
        return "insert into " +
                entityClassMetaData.getName() +
                "(" + String.join(", ", entityClassMetaData.getAllFields()) + ") " +
                "values " + String.join(" :", entityClassMetaData.getAllFields());
    }

    @Override
    public String getUpdateSql() {
        StringBuilder updateString = new StringBuilder("update " + entityClassMetaData.getName() + "set ");
        for(Field field : (List<Field>) entityClassMetaData.getFieldsWithoutId()){
            updateString.append(field.getName())
                        .append(" = :")
                        .append(field.getName());
        }

        updateString.append(" where ")
                    .append(entityClassMetaData.getIdField())
                    .append(" = :")
                    .append(entityClassMetaData.getIdField());
        return updateString.toString();
    }

}
