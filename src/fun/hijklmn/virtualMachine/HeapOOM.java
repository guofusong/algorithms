package fun.hijklmn.virtualMachine;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    // -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError

    static class OOMObject {}

    public static void main(String[] args) {

        List<OOMObject> oomObjectList = new ArrayList<>();

        while (true) {
            oomObjectList.add(new OOMObject());
        }

    }

}
