package nz.net.osnz.demos.spi;

import nz.net.osnz.demos.spi.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by kdeng on 1/04/14.
 */
public class CompareTest {

    private static ServiceLoader<Comparator> serviceLoader = ServiceLoader.load(Comparator.class);

    User oldMan = new User(32);

    User youngMan = new User(23);

    User kid = new User(3);

    @Test
    public void testPersonAgeCompare() {

        List<User> userList = new ArrayList<User>();
        userList.add(oldMan);
        userList.add(kid);
        userList.add(youngMan);

        assert userList.get(0).getAge() == 32;
        assert userList.get(1).getAge() == 3;
        assert userList.get(2).getAge() == 23;

        Collections.sort(userList, getComparator());

        assert userList.get(0).getAge() == 3;
        assert userList.get(1).getAge() == 23;
        assert userList.get(2).getAge() == 32;

    }

    @SuppressWarnings("unchecked")
    protected static Comparator<User> getComparator() {
        for(Comparator service : serviceLoader)
        {
            return (Comparator<User>) service;
        }
        return null;
    }




}
