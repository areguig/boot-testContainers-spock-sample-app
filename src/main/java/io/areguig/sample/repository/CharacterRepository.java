package io.areguig.sample.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import io.areguig.sample.entity.Character;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

/**
 * Created by akli on 31/03/2017.
 */
@Repository
public class CharacterRepository {

    @Autowired
    private DSLContext dsl;

    public List<Character> selectCharacters(){
        return dsl.select(
                    field("id"),
                    field("first_name"),
                    field("last_name"),
                    field("show_name").as("showName"))
                .from(table("characters"))
                .fetchInto(Character.class);
    }

    public Character selectCharacter(Long id){
        return dsl.select(
                    field("id"),
                    field("first_name"),
                    field("last_name"),
                    field("show_name").as("showName"))
                .from(table("characters"))
                .where(field("id").eq(id))
                .fetchOneInto(Character.class);
    }

    public Character createCharacter(Character c){
       return dsl.insertInto(table("characters"))
                .columns(
                        field("first_name"),
                        field("last_name"),
                        field("show_name")
                    ).values(c.getFirstName(),c.getLastName(),c.getShowName())
                .returning(field("id"),
                        field("first_name"),
                        field("last_name"),
                        field("show_name")).fetchOne().into(Character.class);
    }

    public boolean deleteCharacter(Long id){
        return dsl.deleteFrom(
                    table("characters"))
                .where(field("id").eq(id))
                .execute()>0;
    }
}
