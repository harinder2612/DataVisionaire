package com.harinder.dvm;


import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class CsvData {

    ArrayList<Entry> values;

    float [] arhar=new float[] {4.1f,0f,3.3f,0f,2.7f,0f,4.2f,0f,0f,0f};
    float [] cotton=new float[] {7.4f,0f,7.2f,7.4f,0f,0f,5.7f,0f,8f,0f};
    float [] gram=new float[] {4.1f,0f,0f,0f,0f,2.7f,0f,0f,0f,2.1f};
    float [] groundnut=new float[] {5.2f,0f,5.3f,0f,3.1f,0f,5.9f,0f,0f,0f};
    float [] maize=new float[] {6.3f,3.3f,0f,0f,3.4f,0f,0f,0f,0f,3.4f};
    float [] moong=new float[] {2f,0f,0f,0f,1.4f,0f,2.6f,1.4f,0f,1.5f};
    float [] mustard=new float[] {0f,0f,3.3f,4.2f,0f,2.6f,0f,0f,0f,3.1f};
    float [] rice=new float[] {7.6f,0f,0f,0f,0f,0f,0f,4.3f,7.0f,0f};
    float [] sugarcane=new float[] {14.8f,0f,0f,0f,14.2f,0f,14.3f,0f,0f,0f};
    float [] wheat=new float[] {0f,0f,0f,0f,0f,3.5f,0f,0f,5.3f,4.9f};

    float [][] main= new float[10][10];


    public ArrayList<Entry> getRiceProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,91793));
        values.add(new Entry(6,93355));
        values.add(new Entry(7,96693));
        values.add(new Entry(8,99172));
        values.add(new Entry(9,89083));
        values.add(new Entry(10,95970));
        values.add(new Entry(11,105301));
        values.add(new Entry(12,105241));
        values.add(new Entry(13,106646));
        values.add(new Entry(14,105482));
        values.add(new Entry(15,104320));
        return values;
    }

    public ArrayList<Entry> getWheatProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,69355));
        values.add(new Entry(6,75807));
        values.add(new Entry(7,78570));
        values.add(new Entry(8,80679));
        values.add(new Entry(9,80804));
        values.add(new Entry(10,86874));
        values.add(new Entry(11,94882));
        values.add(new Entry(12,93506));
        values.add(new Entry(13,95850));
        values.add(new Entry(14,86527));
        values.add(new Entry(15,93500));
        return values;
    }

    public ArrayList<Entry> getMaizeProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,14710));
        values.add(new Entry(6,15097));
        values.add(new Entry(7,18955));
        values.add(new Entry(8,19731));
        values.add(new Entry(9,16720));
        values.add(new Entry(10,21726));
        values.add(new Entry(11,21759));
        values.add(new Entry(12,22258));
        values.add(new Entry(13,24259));
        values.add(new Entry(14,24173));
        values.add(new Entry(15,21810));
        return values;
    }

    public ArrayList<Entry> getGramProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,5600));
        values.add(new Entry(6,6334));
        values.add(new Entry(7,5749));
        values.add(new Entry(8,7060));
        values.add(new Entry(9,7476));
        values.add(new Entry(10,8221));
        values.add(new Entry(11,7702));
        values.add(new Entry(12,8833));
        values.add(new Entry(13,9526));
        values.add(new Entry(14,7332));
        values.add(new Entry(15,7170));
        return values;
    }


    public ArrayList<Entry> getArharProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,2738));
        values.add(new Entry(6,2314));
        values.add(new Entry(7,3076));
        values.add(new Entry(8,2266));
        values.add(new Entry(9,2465));
        values.add(new Entry(10,2654));
        values.add(new Entry(11,3023));
        values.add(new Entry(12,3174));
        values.add(new Entry(13,2807));
        values.add(new Entry(14,2861));
        values.add(new Entry(15,2460));
        return values;
    }


    public ArrayList<Entry> getMoongProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,5046));
        values.add(new Entry(6,5550));
        values.add(new Entry(7,5937));
        values.add(new Entry(8,5240));
        values.add(new Entry(9,4720));
        values.add(new Entry(10,7159));
        values.add(new Entry(11,6733));
        values.add(new Entry(12,6486));
        values.add(new Entry(13,6555));
        values.add(new Entry(14,7013));
        values.add(new Entry(15,6840));
        return values;
    }

    public ArrayList<Entry> getGroundProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,7993));
        values.add(new Entry(6,4864));
        values.add(new Entry(7,9183));
        values.add(new Entry(8,7168));
        values.add(new Entry(9,5428));
        values.add(new Entry(10,6964));
        values.add(new Entry(11,4694));
        values.add(new Entry(12,9714));
        values.add(new Entry(13,7402));
        values.add(new Entry(14,8266));
        values.add(new Entry(15,6771));
        return values;
    }

    public ArrayList<Entry> getMustardProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,8131));
        values.add(new Entry(6,7438));
        values.add(new Entry(7,5834));
        values.add(new Entry(8,7201));
        values.add(new Entry(9,6608));
        values.add(new Entry(10,8179));
        values.add(new Entry(11,6604));
        values.add(new Entry(12,8029));
        values.add(new Entry(13,7877));
        values.add(new Entry(14,6282));
        values.add(new Entry(15,6821));
        return values;
    }

    public ArrayList<Entry> getCottonProduction()
    {
        values= new ArrayList<>();

        values.add(new Entry(5,18499));
        values.add(new Entry(6,22632));
        values.add(new Entry(7,25884));
        values.add(new Entry(8,22276));
        values.add(new Entry(9,24022));
        values.add(new Entry(10,33000));
        values.add(new Entry(11,35200));
        values.add(new Entry(12,34220));
        values.add(new Entry(13,35902));
        values.add(new Entry(14,34805));
        values.add(new Entry(15,30147));
        return values;
    }

    public ArrayList<String> getCropResults(String cropName)
    {
        ArrayList<String> list= new ArrayList<>();

        switch (cropName)
        {
            case "GroundNuts":{
                list.add("Bihar");
                list.add("Gujarat");
                list.add("AndhraPradesh");
                list.add("Maharashtra");
                list.add("UttarPradesh");
            }break;

            case "Gram":{
                list.add("MadhyaPradesh");
                list.add("Gujarat");
                list.add("Rajasthan");
                list.add("Maharashtra");
                list.add("UttarPradesh");
            }break;

            case "Mustard":{
                list.add("MadhyaPradesh");
                list.add("Gujarat");
                list.add("AndhraPradesh");
                list.add("Maharashtra");
                list.add("UttarPradesh");
                list.add("Bihar");
            }break;

            case "Arhar":{
                list.add("Bihar");
                list.add("Gujarat");
                list.add("Rajasthan");
                list.add("Maharashtra");
                list.add("UttarPradesh");
            }break;

            case "Maize":{
                list.add("Bihar");
                list.add("Gujarat");
                list.add("Rajasthan");
                list.add("Maharashtra");
                list.add("UttarPradesh");
            }break;

            case "Moong":{
                list.add("Bihar");
                list.add("AndhraPradesh");
                list.add("Maharashtra");
            }break;

            case "Cotton":{
                list.add("Rajasthan");
                list.add("Gujarat");
                list.add("AndhraPradesh");
                list.add("Maharashtra");
            }break;

            case "Wheat":{
                list.add("Haryana");
                list.add("Punjab");
                list.add("Rajasthan");
                list.add("UttarPradesh");
            }break;

            case "Rice":{
                list.add("Bihar");
                list.add("Gujarat");
                list.add("AndhraPradesh");
                list.add("Maharashtra");
                list.add("WestBengal");
            }break;

            case "Sugarcane":{
                list.add("Bihar");
                list.add("Gujarat");
                list.add("AndhraPradesh");
                list.add("Maharashtra");
                list.add("UttarPradesh");
            }break;

        }

        return list;
    }


    public List<BarEntry> getCostEntries()
    {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, new float[] {4.1f,7.4f,4.1f,5.2f,6.3f,2.0f,0,7.6f,14.8f,0}));
        entries.add(new BarEntry(1f, new float[] {0,0,0,0,3.3f,0,0,0,0,0}));
        entries.add(new BarEntry(2f, new float[] {3.3f,7.2f,0,5.3f,0,0,3.3f,0,0,0}));
        entries.add(new BarEntry(3f, new float[] {0,7.4f,0,0,3.3f,0,4.2f,0,0,0}));
        entries.add(new BarEntry(4f, new float[] {2.7f,0,0,3.1f,3.4f,1.4f,0,0,14.2f,0}));
        entries.add(new BarEntry(5f, new float[] {0,0,2.7f,0,0,0,2.6f,0,0,3.5f}));
        entries.add(new BarEntry(6f, new float[] {4.2f,5.7f,3.2f,5.9f,0,2.6f,0,0,14.3f,0}));
        entries.add(new BarEntry(7f, new float[] {0,0,0,0,0,1.4f,0,4.3f,0,0}));
        entries.add(new BarEntry(8f, new float[] {0,8,0,0,0,7.0f,0,0,0,5.3f}));
        entries.add(new BarEntry(9f, new float[] {0,0,2.1f,0,3.4f,1.5f,3.1f,0,0,4.9f}));

        return entries;
    }


    public float[][] getCostForCrops(int []arr)
    {
        float temp[]= new float[10];
        List<BarEntry> entries = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            for(int l=0;l<10;l++)
            {
                main[i][l]=0f;
            }
        }

        for(int i=0;i<10;i++)
        {
            if(arr[i]==1)
            {
                switch (i)
                {
                    case 0:{
                                for(int j=0;j<10;j++)
                                {
                                    main[j][i]=arhar[j];
                                }
                            }break;
                    case 1:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=cotton[j];
                        }
                    }break;

                    case 2:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=gram[j];
                        }
                    }break;

                    case 3:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=groundnut[j];
                        }
                    }break;

                    case 4:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=maize[j];
                        }
                    }break;

                    case 5:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=moong[j];
                        }
                    }break;

                    case 6:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=mustard[j];
                        }
                    }break;

                    case 7:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=rice[j];
                        }
                    }break;

                    case 8:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=sugarcane[j];
                        }
                    }break;

                    case 9:{
                        for(int j=0;j<10;j++)
                        {
                            main[j][i]=wheat[j];
                        }
                    }break;

                }
            }
        }

        return main;
    }
}
