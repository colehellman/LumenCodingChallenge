package impl;

import classes.Records;
import classes.Values;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StringToStructureImpl {
    private void printTree(Multimap<Records, Values> table)
    {
        Set<String> alreadyPrintedRecord1s = Sets.newHashSet();

        for (Records r : table.keySet())
        {
            if (!alreadyPrintedRecord1s.contains(r.r1))
            {
                System.err.println(r.r1);
                alreadyPrintedRecord1s.add(r.r1);
            }

            System.err.println("\t" + r.r2);

            Collection<Values> allValues = table.get(r);

            for (Values v : allValues)
            {
                System.err.println("\t\t" + v.v1 + " , " + v.v2);
            }
        }
    }

    private Multimap<Records, Values> indexData(List<String> lines)
    {
        Multimap<Records, Values> table = ArrayListMultimap.create();

        for (String row : lines)
        {
            Iterable<String> split = Splitter.on(",").split(row);
            String[] data = Iterables.toArray(split, String.class);

            table.put(new Records(data[0], data[1]), new Values(data[2], data[3]));
        }
        return table;
    }

    private List<String> getAllDataRows()
    {
        List<String> lines = Collections.emptyList();

        try
        {
            lines = Files.readAllLines(new File("/resources/family.csv"), Charsets.US_ASCII);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        lines.remove(0);// remove header

        return lines;
    }
}
