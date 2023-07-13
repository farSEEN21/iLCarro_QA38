package manager;

import models.User;
import models.UserLombok;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> UserDTO(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp!")});
        list.add(new Object[]{new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp!")});
        list.add(new Object[]{new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp!")});
        list.add(new Object[]{new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp! ")});
        return list.iterator();

    }



}
