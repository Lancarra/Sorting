package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15]; // Creating an array of 15 integers
        Random random = new Random(); // Creating a Random object for generating random numbers

        // Filling the array with random integers between 1 and 100
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        // Printing the initial view of the array
        System.out.println("Initial view of the array: " + Arrays.toString(array));

        // Sorting the array using insertion sort
        insertionSort(array);

        // Printing the sorted array
        System.out.println("Sorted array: " + Arrays.toString(array));

        Scanner scanner = new Scanner(System.in); // Creating a Scanner object for user input
        String userInput; // Variable to store user's response

        do {
            // Asking the user to enter a number to search for
            System.out.print("Enter the number to search for: ");
            int numberToFind = scanner.nextInt(); // Reading the number from the user
            int index = binarySearch(array, numberToFind); // Searching for the number using binary search

            // Printing the result of the search
            if (index >= 0) {
                System.out.println("Number index " + numberToFind + " in a sorted array: " + index);
            } else {
                System.out.println("Number " + numberToFind + " is not found in the array.");
            }

            // Asking the user if they want to continue
            System.out.print("Do you want to continue? (y/n): ");
            userInput = scanner.next(); // Reading the user's response
        } while (userInput.equalsIgnoreCase("y")); // Looping until the user enters 'n' or 'N'

        scanner.close(); // Closing the scanner
        }

        // Method for sorting the array using insertion sort algorithm
        public static void insertionSort(int[] array) {
            for (int i = 1; i < array.length; i++) {
                int key = array[i]; // Storing the current element in key
                int j = i - 1; // Initializing j to the previous element's index

                // Shifting elements of the sorted segment to the right to make space for key
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key; // Placing the key in its correct position
            }
        }

        // Method for performing binary search on the sorted array
        public static int binarySearch(int[] array, int numberToFind) {
            int left = 0; // Initializing the left boundary of the search
            int right = array.length - 1; // Initializing the right boundary of the search

            // Looping until the boundaries meet
            while (left <= right) {
                int mid = left + (right - left) / 2; // Calculating the middle index

                // Checking if the number is present at mid
                if (array[mid] == numberToFind) {
                    return mid; // Returning the index if the number is found
                }

                // If the number is greater, ignore the left half
                if (array[mid] < numberToFind) {
                    left = mid + 1;
                } else {
                    // If the number is smaller, ignore the right half
                    right = mid - 1;
                }
            }

        return -1; // Returning -1 if the number is not found
    }
}