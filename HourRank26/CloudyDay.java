//https://www.hackerrank.com/contests/hourrank-26/challenges/cloudy-day
package HourRank26;

import java.util.ArrayList;
import java.util.Scanner;

class CloudyDay {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int towns = input.nextInt();
		int populationArray[] = new int[towns];
		int townCoordinateArray[] = new int[towns];
		
		for(int index=0; index<towns; index++){
			populationArray[index] = input.nextInt();
		}
		
		for(int index=0; index<towns; index++){
			townCoordinateArray[index] = input.nextInt();
		}
		
		int numberOfClouds = input.nextInt();
		int cloudCoordinates[] = new int[numberOfClouds];
		int rangeCoveredByCloud[] = new int[numberOfClouds];
		
		for(int index=0; index<numberOfClouds; index++){
			cloudCoordinates[index] =  input.nextInt();
		}
		for(int index=0; index<numberOfClouds; index++){
			rangeCoveredByCloud[index] = input.nextInt();
		}
		System.out.println(findMaximumPeopleWithSunnyDay(populationArray, townCoordinateArray, cloudCoordinates, rangeCoveredByCloud));
	}
	public static int findMaximumPeopleWithSunnyDay(int populationArray[], int townCoordinateArray[], int cloudCoordinates[], int rangeCoveredByCloud[]){
		int maxPeople = 0;
		ArrayList<Integer> finalcloudCoordinates = new ArrayList<Integer>();
		for(int index=0, yIndex=0; index<cloudCoordinates.length && yIndex<rangeCoveredByCloud.length; index++, yIndex++){
			int coordinate = cloudCoordinates[index];
			int range = rangeCoveredByCloud[yIndex];
			for(int mindex=coordinate; mindex<=coordinate+range; mindex++){
				finalcloudCoordinates.add(mindex);
			}
			for(int mindex=coordinate-range; mindex<coordinate; mindex++){
				finalcloudCoordinates.add(mindex);
			}
		}
		for(int index=0; index<finalcloudCoordinates.size(); index++){
			System.out.println(finalcloudCoordinates.get(index));
		}
		for(int index=0; index<townCoordinateArray.length; index++){
			for(int jIndex=0; jIndex<finalcloudCoordinates.size(); jIndex++){
				if(townCoordinateArray[index] == finalcloudCoordinates.get(jIndex)){
					maxPeople = (maxPeople < populationArray[index]) ? (maxPeople + populationArray[index])  : maxPeople;
				}else{
					//maxPeople = maxPeople + populationArray[index];
				}
			}
		}
		return maxPeople;
	}
}
