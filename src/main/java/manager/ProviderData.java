package manager;

import models.User;
import models.UserLombok;
import org.testng.annotations.DataProvider;

import java.io.*;
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

    @DataProvider
    public Iterator<Object[]> UserDTOCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/RegDataset.csv")));
        String line=reader.readLine();
        while (line!=null){
            String[] split=line.split(",");
            list.add(new Object[]{new User().withEmail(split[2]).withPsw(split[3]).withLastname(split[1]).withName(split[0])});
             line=reader.readLine();
        }
        return list.iterator();
    }



}
