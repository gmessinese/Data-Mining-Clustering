package data;
import java.util.Random;
import utility.ArraySet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Set;
import java.util.HashSet;

public class Data {
    private List<Example> data; // list of transactions
    private int numberOfExamples; // number of transactions
    private List<Attribute> attributeSet;

    class Example implements Comparable<Example> {
        private List<Object> example = new ArrayList<Object>();
        
        void add(Object o) {
            example.add(o);
        }
        
        Object get(int i) {
            return example.get(i);        
        }
        
        int size() {
            return example.size();
        }
        
        public int compareTo(Example ex) {
            if(example.size() != ex.size()) {
                throw new SizeNotEquivalentException();
            }
            int match = 0;
            int i = 0;

            while(i < example.size() && match == 0) {
                match = get(i).compareTo(ex.get(i)); // compareTo is undefined method for type Object
                i++;
            }
                
            return match;
        }
        
        public String toString() {
            String str = "";
            for(Object o: example) {
                str = str + o.toString();
            }
            return str;
        }
    }
    
    public Data() {       
        attributeSet = new LinkedList<Attribute>();
        TreeSet<Example> tempData = new TreeSet<Example>();
        
        /* Populate attributeSet */
        TreeSet<String> outLookValues = new TreeSet<String>();
        outLookValues.add("overcast");
        outLookValues.add("rain");
        outLookValues.add("sunny");
        attributeSet.add(new DiscreteAttribute("Outlook", outLookValues));
        
        TreeSet<String> temperatureValues = new TreeSet<String>();
        temperatureValues.add("cool");
        temperatureValues.add("mild");
        temperatureValues.add("hot");
        attributeSet.add(new DiscreteAttribute("Temperature", temperatureValues));
        
        TreeSet<String> humidityValues = new TreeSet<String>();
        humidityValues.add("normal");
        humidityValues.add("high");
        attributeSet.add(new DiscreteAttribute("Humidity", humidityValues));
        
        TreeSet<String> windValues = new TreeSet<String>();
        windValues.add("weak");
        windValues.add("strong");
        attributeSet.add(new DiscreteAttribute("Wind", windValues));
        
        TreeSet<String> playTennisValues = new TreeSet<String>();
        playTennisValues.add("yes");
        playTennisValues.add("no");
        attributeSet.add(new DiscreteAttribute("Play Tennis", playTennisValues));
        
        /* Examples */
        Example ex1 = new Example();
        Example ex2 = new Example();
        Example ex3 = new Example();
        Example ex4 = new Example();
        Example ex5 = new Example();
        Example ex6 = new Example();
        Example ex7 = new Example();
        Example ex8 = new Example();
        Example ex9 = new Example();
        Example ex10 = new Example();
        Example ex11 = new Example();
        Example ex12 = new Example();
        Example ex13 = new Example();
        Example ex14 = new Example();
        
        ex1.add(new String("sunny"));
        ex1.add(new String("hot"));
        ex1.add(new String("high"));
        ex1.add(new String("weak"));
        ex1.add(new String("no"));
        
        ex2.add(new String("sunny"));
        ex2.add(new String("hot"));
        ex2.add(new String("high"));
        ex2.add(new String("strong"));
        ex2.add(new String("no"));
        
        ex3.add(new String("overcast"));
        ex3.add(new String("hot"));
        ex3.add(new String("high"));
        ex3.add(new String("weak"));
        ex3.add(new String("yes"));
        
        ex4.add(new String("rain"));
        ex4.add(new String("mild"));
        ex4.add(new String("high"));
        ex4.add(new String("weak"));
        ex4.add(new String("yes"));
        
        ex5.add(new String("rain"));
        ex5.add(new String("cool"));
        ex5.add(new String("normal"));
        ex5.add(new String("weak"));
        ex5.add(new String("yes"));
        
        ex6.add(new String("rain"));
        ex6.add(new String("cool"));
        ex6.add(new String("normal"));
        ex6.add(new String("strong"));
        ex6.add(new String("no"));
        
        ex7.add(new String("overcast"));
        ex7.add(new String("cool"));
        ex7.add(new String("normal"));
        ex7.add(new String("strong"));
        ex7.add(new String("yes"));
        
        ex8.add(new String("sunny"));
        ex8.add(new String("mild"));
        ex8.add(new String("high"));
        ex8.add(new String("weak"));
        ex8.add(new String("no"));
        
        ex9.add(new String("sunny"));
        ex9.add(new String("cool"));
        ex9.add(new String("normal"));
        ex9.add(new String("weak"));
        ex9.add(new String("yes"));
        
        ex10.add(new String("rain"));
        ex10.add(new String("mild"));
        ex10.add(new String("normal"));
        ex10.add(new String("weak"));
        ex10.add(new String("yes"));
        
        ex11.add(new String("sunny"));
        ex11.add(new String("mild"));
        ex11.add(new String("normal"));
        ex11.add(new String("strong"));
        ex11.add(new String("yes"));
        
        ex12.add(new String("overcast"));
        ex12.add(new String("mild"));
        ex12.add(new String("high"));
        ex12.add(new String("strong"));
        ex12.add(new String("yes"));
        
        ex13.add(new String("overcast"));
        ex13.add(new String("hot"));
        ex13.add(new String("normal"));
        ex13.add(new String("weak"));
        ex13.add(new String("yes"));
        
        ex14.add(new String("rain"));
        ex14.add(new String("mild"));
        ex14.add(new String("high"));
        ex14.add(new String("strong"));
        ex14.add(new String("no"));
        
        /* Add examples to tempData(which is a set) in order to avoid duplicates */
        tempData.add(ex1);
        tempData.add(ex2);
        tempData.add(ex3);
        tempData.add(ex4);
        tempData.add(ex5);
        tempData.add(ex6);
        tempData.add(ex7);
        tempData.add(ex8);
        tempData.add(ex9);
        tempData.add(ex10);
        tempData.add(ex11);
        tempData.add(ex12);
        tempData.add(ex13);
        tempData.add(ex14); 
        data = new ArrayList<Example>(tempData); 
        numberOfExamples = data.size();  
    }
    
    public int getNumberOfExamples() {
        return numberOfExamples;
    }
    
    public int getNumberOfAttributes() {
        return attributeSet.size();
    }
    
    public Object getAttributeValue(int exampleIndex, int attributeIndex) {
        return data.get(exampleIndex).get(attributeIndex);
    }
    
    Attribute getAttribute(int index) {
        return attributeSet.get(index);
    }
    
    public String toString() {
        String str = "";
        // print attributes
        for(int i = 0; i < attributeSet.size(); i++) {
            str = str + attributeSet.get(i).toString() + "  ";
        }
        // print data
        str = str + "\n";
        for(int i = 0; i < numberOfExamples; i++) {
            str = str + (i + 1) + ") ";
            for(int j = 0; j < attributeSet.size(); j++) {
                str = str + data.get(i).get(j) + "   ";
            }
            str = str + "\n";
        }
        return str;
    }
    
    public Tuple getItemSet(int index) {
        Tuple tuple = new Tuple(attributeSet.size());
        int i;
        for(i = 0; i < attributeSet.size(); i++)
            tuple.add(
                new DiscreteItem((DiscreteAttribute)attributeSet.get(i), (String)data.get(index).get(i)),
                i
            );
        return tuple;
    }
    
    /* k is the number of cluster to generate. This method return a k dimension array, whose 
     * elements represent the index of the tuples(row index of data matrix) which
     * have been initially chosen as centroids(first step of k-means)
     */

    public int[] sampling(int k) throws OutOfRangeSampleSize {
        // exception
        if(k <= 0 || k > numberOfExamples) throw new OutOfRangeSampleSize();
        int centroidIndexes[] = new int[k];
        // choose k random different centroids in data.
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        // init k random centroids.
        for(int i = 0; i < k; i++) {
            boolean found = false;
            int c;
            do {
                found = false;
                // chose a random index.
                c = rand.nextInt(getNumberOfExamples());
                // verify that centroid[c] is not equal to a centroid already stored in CentroidIndexes.
                for(int j = 0; j < i; j++) {
                    if(compare(centroidIndexes[j], c)) {
                        found = true;
                        break;
                    }
                }
            } while(found);        
            centroidIndexes[i] = c;
        }
        return centroidIndexes;
    }
    
    private boolean compare(int i, int j) {
        boolean equal = true;
        int k = 0;
        while(k < attributeSet.size() && equal) {
            if(getAttributeValue(i, k) != getAttributeValue(j, k)) {
                equal = false;
            }
            k++;
        }
        return equal;
    }

    Object computePrototype(Set<Integer> idList, Attribute attribute) {
        return computePrototype(idList, (DiscreteAttribute) attribute);
    }
    
    private String computePrototype(Set<Integer> idList, DiscreteAttribute attribute) {
        int comp;
        int freq = 0;
        String centroid = "";
        // Look for the most frequent value of attribute in tuples stored in idList.
        for(String str: attribute) {
            comp = attribute.frequency(this, idList, str);
            if(comp > freq) {
                freq = comp;
                centroid = str;
            }
        }
        return centroid;
    }
}

