import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie implements Comparable<Movie>
{
    String title;
    double rating;
    int year;

    Movie(String title,double rating,int year)
    {
        setTitle(title);
        setRating(rating);
        setYear(year);
    }

    //Setters
    public void setRating(double rating) 
    {
        if (rating>10 || rating<0) 
        {
            System.out.println("Invalid rating can be between 0-10");
        }
        else
        {
            this.rating=rating;
        }
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setYear(int year) 
    {
        if (year<1950 || year>2026)
        {
            System.out.println("Invalid year can be between 1950-2026");
        }
        else
        {
            this.year=year;
        }
    }

    //Getters

    public double getRating() {
        return rating;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie that)
    {
        return this.title.compareTo(that.title);
    }


    @Override
    public String toString()
    {
        return String.format("Movie  : %s\nRating : %.1f\nYear   : %d\n", title, rating, year);
    }
}
public class ObjectsSorting
{
    public static void main(String[] args) 
    {
        ArrayList <Movie> movies = new ArrayList<>();

        movies.add(new Movie("Inception", 8.8, 2010));
        movies.add(new Movie("Interstellar", 8.6, 2014));
        movies.add(new Movie("The Dark Knight", 9.0, 2008));
        movies.add(new Movie("Tenet", 7.5, 2020));
        movies.add(new Movie("Dunkirk", 7.9, 2017));
        movies.add(new Movie("Oppenheimer", 8.4, 2023));


        //Dscending Order :
        Comparator <Movie> ratingComparatorDescend = (m1,m2) -> Double.compare(m2.rating,m1.rating); 
        //Ascending Order
        Comparator <Movie> ratingComparatorAscend=(m1,m2) -> Double.compare(m1.rating,m2.rating);
        //Year Comparators :
        Comparator <Movie> yearComparatorAscend=(m1,m2)-> m1.getYear()-m2.getYear();
        Comparator <Movie> yearComparatorDescend=(m1,m2)-> m2.getYear()-m1.getYear();


        System.out.println();
        System.out.println("Default Order Of Movies : ");
        for (Movie m : movies)
        {
            System.out.println(m.toString());
        }
        System.out.println();



        System.out.println("Sorting by title :");
        System.out.println();
        Collections.sort(movies);    
        for (Movie m : movies)
        {
            System.out.println(m.toString());
        }
        System.out.println();

        System.out.println("Sorting by year (ascending) :");
        movies.sort(yearComparatorAscend);  
        for (Movie m : movies)
        {
            System.out.println(m.toString());
        }
        System.out.println();


        System.out.println("Sorting by year (descending) :");
        movies.sort(yearComparatorDescend);  
        for (Movie m : movies)
        {
            System.out.println(m.toString());
        }
        System.out.println();



        System.out.println("Sorting by rating (ascending) :");
        movies.sort(ratingComparatorAscend);  
        for (Movie m : movies)
        {
            System.out.println(m.toString());
        }
        System.out.println();



        System.out.println("Sorting by rating (descending) :");
        movies.sort(ratingComparatorDescend);  
        for (Movie m : movies)
        {
            System.out.println(m.toString());
        }
        System.out.println();


    }
}
