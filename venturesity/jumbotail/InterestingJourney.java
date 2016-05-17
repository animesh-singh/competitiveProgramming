import java.util.*;
import java.io.*;

/*
 
Problem: An Interesting Journey
Author: Animesh Singh
Email: animeshsingh1993@gmail.com
 
Assumptions
1. City names are not limited to single characters and can be entered as Bangalore -> Chennai -> Delhi
2. Number of trips are less than 10^18.
3. In the real world scenario the best solution would be to use graph and find all the back edges.
4. For a quick solution, using a hashMap to solve this problem.
 
*/

class HelloWorld
{
	public static void main(String asd[]) throws IOException,Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                                // Input the number of trips
		long noTrips = Long.parseLong(br.readLine());

                                // Input the cities
		String trips = br.readLine();

/*                          
    ##############################################################
    #          Input validation done                             #
    #          Now check for the number of back edges            #
    ##############################################################
*/                            

        // remove all the special characters from the string
                trips = trips.replaceAll("[^\\w\\*]", " ");

                                // split the cities into a string array
                String[] cities = trips.split("\\s+");

                                // check if input has at least 2 cities
                if(cities.length < 2)
                {
                                                //System.out.println("Invalid input entered, enter at least 2 cities");
                	throw new Exception("Invalid input entered, enter atleast 2 cities");
                }


/*                          
    ##############################################################
    #           Input validation done                            #
    #           Now check for the number of back edges           #
    ##############################################################
*/                                          


                HashMap<String,Integer> MapCities = new HashMap<String,Integer>();
                long count = 0;

                for (int i = 0 ; i < cities.length ; i++)
                {
                	if( i+1 < cities.length && cities[i+1].equals(cities[i]) )
                	{
    					// means the person is in the same city (self loop) we will skip it
                		continue;
                	}

                	if(MapCities.containsKey(cities[i]))
                	{
                		count++;

    					// ####### UNCOMMENT TO CHECK HOW MANY TIMES WAS A PERTICULAR CITY VISITED ######

                        //MapCities.put(cities[i],MapCities.get(cities[i])+1);
                	}
                	else
                	{
                        // New city travelled, add it to the Map.
                		MapCities.put(cities[i],1);

                	}

                }

                System.out.println(count);

                Iterator iterator = MapCities.keySet().iterator();

        // ##### UNCOMMENT TO CHECK HOW MANY TIMES WAS A PERTICULAR CITY VISITED ######

        // while (iterator.hasNext()) {
        //   String key = iterator.next().toString();
        //   String value = MapCities.get(key).toString();

        //   System.out.println(key + " " + value);
        // }

            }


        }