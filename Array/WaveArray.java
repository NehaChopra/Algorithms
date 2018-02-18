//https://practice.geeksforgeeks.org/problems/wave-array/0
package Array;

import java.util.Scanner;

class WaveArray {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int test = 0; test<testCases; test++){
			int arrayLength = input.nextInt();
			int array[] = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			sortAnArrayInWaveForm(array);
			
			for(int index=0; index<arrayLength; index++){
				System.out.print(array[index] + " ");
			}
			System.out.println();
		}
	}
	public static void sortAnArrayInWaveForm(int array[]){
		sortArray(array);
		organizeWaveForm(array);
	}
	public static void sortArray(int inputArray[]){
		for(int iIndex=inputArray.length/2 - 1; iIndex>=0; iIndex--){
			heapify(inputArray, inputArray.length, iIndex);
		}
		
		for(int jIndex= inputArray.length - 1; jIndex>=0; jIndex--){
			swap(inputArray, jIndex, 0);
			heapify(inputArray, jIndex, 0);
		}
	}
	public static void heapify(int[] inputArray, int end, int index){
		int largest = index;
		int left = getLeft(index);
		int right = getRight(index);
		if(left < end && inputArray[left] > inputArray[largest]){
			largest = left;
		}
		
		if(right < end && inputArray[right] > inputArray[largest]){
			largest = right;
		}
		
		if(largest != index){
			swap(inputArray, index, largest);
			heapify(inputArray, end, largest);
		}
	}
	public static void swap(int[] inputArray, int index, int jIndex){
		int temp = inputArray[index];
		inputArray[index] = inputArray[jIndex];
		inputArray[jIndex] = temp;
	}
	public static int getLeft(int index){
		return (2*index + 1);
	}
	public static int getRight(int index){
		return (2*index + 2);
	}
	public static void organizeWaveForm(int array[]){
		if(array.length == 2){
			int temp = array[0];
			array[0] = array[1];
			array[1] = temp;
		}else{
			for(int index=0; index<=array.length - 2; index = index+2){
				int temp = array[index];
				array[index] = array[index + 1];
				array[index + 1] = temp;
			}
		}
	}
}

/*


https://scotch.io/tutorials/getting-started-with-node-express-and-postgres-using-sequelize
https://scotch.io/tutorials/creating-an-angularjs-application-with-sequelize-part-1
http://jasonwatmore.com/post/2015/12/09/mean-stack-user-registration-and-login-example-tutorial
http://jasonwatmore.com/post/2017/02/22/mean-with-angular-2-user-registration-and-login-example-tutorial
http://mherman.org/blog/2017/01/05/token-based-authentication-with-angular/#.WnyUnd99JNw
https://auth0.com/blog/angular-2-authentication/
https://devdactic.com/restful-api-user-authentication-1/
https://www.sitepoint.com/user-authentication-mean-stack/
https://github.com/scotch-io/bookmark/tree/master/server
https://github.com/JStubb7939/halp-desk
https://medium.com/@jstubblefield7939/part-ii-front-end-creating-a-single-page-application-with-angularjs-719192b27bd
https://medium.com/@jstubblefield7939/creating-a-single-page-app-with-angularjs-f9e18624d94d
https://github.com/solonm/NodeJs-AngularJs-PostgreSQL
https://github.com/StetSolutions/pean
https://www.quora.com/How-do-I-link-Node-js-+-Postgres-with-an-AngularJS-app
https://scotch.io/courses/build-a-restful-nodejs-api/introduction
https://codepen.io/ge1doot/pen/LkdOwj
https://github.com/delight-im/ShortURL
https://gist.github.com/zumbojo/1073996
https://stackoverflow.com/questions/742013/how-to-code-a-url-shortener
http://n00tc0d3r.blogspot.in/
https://www.geeksforgeeks.org/array-data-structure/#rearrange
https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/
https://practice.geeksforgeeks.org/problems/wave-array/0
https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
https://www.geeksforgeeks.org/sort-an-array-according-to-absolute-difference-with-given-value/
https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/
https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
https://en.wikipedia.org/wiki/Ajax_(programming)
https://en.wikipedia.org/wiki/Comet_(programming)
https://www.geeksforgeeks.org/indexing-in-databases-set-1/
http://ext2.sourceforge.net/2005-ols/paper-html/node3.html
https://en.wikipedia.org/wiki/Splay_tree
https://www.geeksforgeeks.org/b-tree-set-1-introduction-2/
https://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
https://www.geeksforgeeks.org/print-binary-tree-levels-sorted-order/
https://practice.geeksforgeeks.org/problems/maximum-gap/0/?ref=self
https://www.geeksforgeeks.org/count-pairs-from-two-bsts-whose-sum-is-equal-to-a-given-value-x/
https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1
http://blog.gainlo.co/index.php/category/system-design-interview-questions/?utm_campaign=quora&utm_medium=How+do+I+answer+design-related+questions%2C+like+design+a+parking+lot%2C+in+an+Amazon+interview%3F&utm_source=quora
https://discuss.leetcode.com/tags/5/object-oriented%20design?page=1
https://www.hackerrank.com/contests/code-the-next/challenges/the-marathon
https://www.careercup.com/question?id=19896668
https://www.hackerrank.com/contests/hourrank-26/challenges
https://practice.geeksforgeeks.org/problems/rotate-and-delete/0


	1K072650207
	45222499
	NEHANAVYUGINFO@GMAIL.COM



	https://www.michaelkors.ca/brooklyn-small-leather-tote/_/R-CA_30H7SBNT1L
	Samsung Code The Next



	 was asked to design Google autocomplete


	https://www.youtube.com/watch?v=_8ObuO5neR0
	https://www.youtube.com/watch?v=7Mni3yDpIWo&t=161s



	https://scotch.io/tutorials/build-an-interactive-command-line-application-with-nodejs



		join@momentumdash.com
		

 * 
 */
