package assignment3;
import java.util.Scanner;


public class grades {
	public static void main( String[] args) {
		Scanner grader = new Scanner(System.in);
		
		System.out.println("What is the weight of your HW?");
		int hwWeight = grader.nextInt();
		System.out.println("What is the weight of your exam 1?");
		int exam1Weight = grader.nextInt();
		int exam2Weight = 100 - (hwWeight + exam1Weight);
		
		System.out.println("Homework 1:");
		System.out.println("How many assignments?");
		int hwNum = grader.nextInt();
		System.out.println("What was your average?");
		double hwAvg = grader.nextDouble();
		System.out.println("How many labs were attended?");
		int labsAttend = grader.nextInt();
		System.out.println("How many Late days were used?");
		int lateDays = grader.nextInt();
		double hwGradeTotal = homeworkGrade(hwNum, hwAvg,lateDays, labsAttend, hwWeight);
		System.out.println(hwGradeTotal);
		
		System.out.println(" ");
		System.out.println("Exam 1:");
		System.out.println("What was your score?");
		double exam1Score = grader.nextDouble();
		System.out.println("What was the curve?");
		int exam1Curve = grader.nextInt();
		double exam1GradeTotal = exams(exam1Weight, exam1Score, exam1Curve);
		System.out.println(exam1GradeTotal);
		
		System.out.println(" ");
		System.out.println("Exam 2:");
		System.out.println("What was your score?");
		double exam2Score = grader.nextDouble();
		System.out.println("What was the curve?");
		int exam2Curve = grader.nextInt();
		double exam2GradeTotal = exams(exam2Weight, exam2Score, exam2Curve);
		System.out.println(exam2GradeTotal);
		grader.close();
		
		double finalGrade = courseTotal(hwGradeTotal, exam1GradeTotal, exam2GradeTotal);
		
		System.out.println(finalGrade);
		
		
		
		
		
		
		
	
		
		
		
		
		
	}
	
	
	public static double homeworkGrade (  int hwNum, double hwAvg, int lateDays, int Labs, int weight) {
		int total_points= 0;
		double points = 0, weightedGrade = 0;
		if(hwNum <= 0) {
			points = 100;
			total_points = 100;
		}else {
			total_points += hwNum *10;
		}
		
		if(hwAvg <= 0) {
			points += 0;
		}else if(hwAvg > 10) {
			points = 10 * hwNum;
		} else {
			 points = hwNum * hwAvg;
		}
		points += Labs *4;
		total_points += 10 *4;
		
		if(lateDays >= (hwNum/2)) {
			points+= points * 0.10;
		}else if( lateDays == 0 && (points < total_points)) {
			points += 5;
		}
		
		System.out.println("Total score: " + points + "/" + total_points);
		
		weightedGrade = (weight * points) / total_points;
		System.out.println("Weighted grade: " + weightedGrade);
		return weightedGrade;
		}
	
	public static double exams( int weight, double score, int curve ) {
		double points = 0, weightedExam;
		int total_points = 100;
		
		if(score <= 0) {
			points +=0;
		}else {
			points = score;
		}
		if(score+ curve < total_points) {
			points += curve;
		}else if( score + curve >= total_points) {
			points = 100;
		}
			System.out.println("Total score: " + points + "/" + total_points);
			weightedExam= (weight * points) / total_points;
			System.out.println("Weighted Score: " + weightedExam);
			return weightedExam;
		
	}
	
	public static double courseTotal(double hwTotal, double exam1Total, double exam2Total) {
		double finalTotal = hwTotal + exam1Total + exam2Total;
		
		return finalTotal;
		
		
	}
	
}