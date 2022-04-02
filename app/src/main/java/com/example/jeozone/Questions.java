package com.example.jeozone;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Questions {
    //Need to store the countries.
        //The 8 images per country.
            //The 3 options per image, specifically the correct one.
    private List<String[]> chPlaces = new ArrayList<>(Arrays.asList(new String[]{"Grand Palace of Bangkok", "House of Dharma", "Manjushri Centre"},
            new String[]{"Great Wall of China", "Vietnam Veterans Memorial Wall", "Long Wall of Quang Ngai"},
            new String[]{"Burj Khalifa", "Al Hamra Tower", "Tokyo Skytree"},
            new String[]{"Cat Island", "Neko-jinja", "Ehime Island"},
            new String[]{"Navel of the World", "Rapa Nui", "Plain of Jars"},
            new String[]{"Taj Arabia", "Taj Mahal of India", "Taj of the Deccan"},
            new String[]{"Mount Fuji", "Hindu Raj", "Himalayas"},
            new String[]{"Burj Khalifa", "Tokyo Skytree", "Tokyo Tower"}));

    private List<String> chCorrects = new ArrayList<>(Arrays.asList("Grand Palace of Bangkok", "Great Wall of China", "Burj Khalifa", "Cat Island", "Plain of Jars", "Taj of the Deccan", "Mount Fuji", "Tokyo Skytree"));

    private List<Integer> chIma = new ArrayList<>(Arrays.asList(R.drawable.grand_palace_bangkok, R.drawable.great_wall_badaling, R.drawable.burj_khalifa,
            R.drawable.cats, R.drawable.jars, R.drawable.taj_deccan, R.drawable.mount_fuji, R.drawable.tokyo_skytree));

    public String country;
    public String[] currentPlace = new String[3];
    public int currentImage;
    public String correct;
    public Random rand = new Random();
    public int currNum = 8;

    public Questions(String country) {
        this.country = country;
    }

    public String generate() {
        int place = rand.nextInt(currNum); //Generates from 0, decreases each time.
        //Removes from each list to avoid duplicates:
        currNum--;
        this.currentPlace = chPlaces.remove(place);
        this.currentImage = chIma.remove(place);
        this.correct = chCorrects.remove(place);

        //Generates random button order:
        List<String> temp = Arrays.asList(currentPlace);
        Collections.shuffle(temp);
        return correct;
    }

    public String[] getCurrentPlace() {
        return currentPlace;
    }

    public int getCurrentImage() {
        return currentImage;
    }





}
