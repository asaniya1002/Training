package com.saniya;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCAssignment {
	public static void main(String[] args) throws SQLException {
		try (Scanner keyboard = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assignment", "root",
						"root");) {
			ResultSet my_rs;
			PreparedStatement ps;

			/*
			 * Statement st = con.createStatement();
			 * st.execute("create table employee(ID numeric(10), fName varchar(50)," +
			 * " lName varchar(50), email varchar(50), address varchar(100)," + " primary
			 * key(ID))"); st.
			 * execute("insert into employee values(101,'Amatul','Saniya','amatul_saniya@hcl.com', 'WA')"
			 * ); st.
			 * execute("insert into employee values(102,'Alex','Davila','alex_davila@hcl.com', 'Florida')"
			 * ); st.
			 * execute("insert into employee values(103,'Fatmana','Kocagul','fatmana@hcl.com', 'Texas')"
			 * ); st.
			 * execute("insert into employee values(104,'Bob','Smith','bob_smith@hcl.com', 'CT')"
			 * ); st.
			 * execute("insert into employee values(105,'Jane','Smith','jane_smith@gmail.com', 'NY')"
			 * ); st.
			 * execute("insert into employee values(106,'Shimmer','Chhor','shimmerC@hotmail.com', 'CA')"
			 * ); st.
			 * execute("insert into employee values(107,'Brandon','Pelayo','BP1020202@gmail.com', 'ID')"
			 * ); st.
			 * execute("insert into employee values(108,'Jeremy','D','jeremyD@yahoo.com', 'Cary')"
			 * ); st.
			 * execute("insert into employee values(109,'Tommy','Hilfiger','tommy@hcl.com', 'Canada')"
			 * ); st.
			 * execute("insert into employee values(110,'Luis','Vuitton','LV@blah.com', 'IDK')"
			 * ); st.
			 * execute("insert into employee values(111,'Michael','Kors','Mikey@yo.com', 'DK')"
			 * ); st.
			 * execute("insert into employee values(112,'Versace','V','vv@hcl.com', 'Chicago')"
			 * ); st.
			 * execute("insert into employee values(113,'Miss','Dior','miss_dior@you.com', 'nowhere')"
			 * ); st.
			 * execute("insert into employee values(114,'Sammy','R','sam@hcl.com', 'India')"
			 * ); st.
			 * execute("insert into employee values(115,'Tammy','S','tammy@google.com', 'LA')"
			 * );
			 */
			boolean keepRunning = true;
			while (keepRunning) {
				System.out.println("\n======================================================================");
				System.out.println("Welcome to the JDBC Explorer!");
				System.out.println("Below is a list of operations you could perform: ");
				System.out.println("Enter 1 to INSERT a record");
				System.out.println("Enter 2 to UPDATE a record by its ID");
				System.out.println("Enter 3 to DELETE a record by its ID");
				System.out.println("Enter 4 to retrieve a record either by first name, last name, or ID");
				System.out.println("Enter 0 to exit");
				System.out.println("======================================================================\n");

				int userInput = keyboard.nextInt();

				switch (userInput) {
				case 0:
					System.out.println("Exiting System!");
					System.exit(0);
					break;
				case 1:

					ps = con.prepareStatement("insert into employee values" + "(?,?,?,?,?)");

					System.out.println("Please enter an ID number: ");
					Integer ID = keyboard.nextInt();

					System.out.println("Please enter your first name: ");
					String fName = keyboard.next();

					System.out.println("Please enter your last name: ");
					String lName = keyboard.next();

					System.out.println("Please enter your email: ");
					String email = keyboard.next();

					System.out.println("Please enter your address: ");
					String address = keyboard.next();

					ps.setInt(1, ID);
					ps.setString(2, fName);
					ps.setString(3, lName);
					ps.setString(4, email);
					ps.setString(5, address);
					ps.execute();
					System.out.println("Employee " + ID + " INSERTED Successfully!");
					break;

				case 2:
					System.out.println("Please enter in the ID whose record you'd like to update: ");
					ps = con.prepareStatement(
							"update employee set fName = ?, lName = ?, email = ?, address = ? where ID = ?");
					int input = keyboard.nextInt();
					ps.setInt(5, input); // get ID from user

					System.out.println("Please update their first name:");
					ps.setString(1, keyboard.next());

					System.out.println("Please update their last name:");
					ps.setString(2, keyboard.next());

					System.out.println("Please update their email:");
					ps.setString(3, keyboard.next());

					System.out.println("Please update their address:");
					ps.setString(4, keyboard.next());
					ps.execute();
					System.out.println("Employee " + input + " UPDATED Successfully!");

					break;

				case 3:
					System.out.println("Please enter in the ID whose record you'd like to delete: ");
					ps = con.prepareStatement("delete from employee where ID = ?");
					ps.setInt(1, keyboard.nextInt());
					ps.execute();
					break;

				case 4:
					System.out.println("Enter in 1 to retrive record by their first name");
					System.out.println("Enter in 2 to retrive record by their first name");
					System.out.println("Enter in 3 to retrive record by their ID");
					int retrieveCode = keyboard.nextInt();
					if (retrieveCode == 1) {
						System.out.println("Please enter in the employee's first name: ");
						ps = con.prepareStatement("select * from employee where fName = ?");
						ps.setString(1, keyboard.next());
						my_rs = ps.executeQuery();
						ResultSetMetaData rsmd = my_rs.getMetaData();

						int numColumns = rsmd.getColumnCount();

						while (my_rs.next()) {
							for (int i = 1; i <= numColumns; i++)
								System.out.print(rsmd.getColumnName(i) + ": " + my_rs.getString(i) + " | ");

							System.out.println();
						}

					} else if (retrieveCode == 2) {

						System.out.println("Please enter in the employee's last name: ");
						ps = con.prepareStatement("select * from employee where lName = ?");
						ps.setString(1, keyboard.next());
						my_rs = ps.executeQuery();
						ResultSetMetaData rsmd = my_rs.getMetaData();

						int numColumns = rsmd.getColumnCount();

						while (my_rs.next()) {
							for (int i = 1; i <= numColumns; i++)
								System.out.print(rsmd.getColumnName(i) + ": " + my_rs.getString(i) + " | ");

							System.out.println();
						}
					} else if (retrieveCode == 3) {
						System.out.println("Enter the employee ID whose record you'd like to retrieve: ");
						CallableStatement cst = con.prepareCall("{call invoke_emp (?)}");
						cst.setInt(1, keyboard.nextInt());
						cst.execute();
						ResultSet rs = cst.executeQuery();

						while (rs.next()) {
							System.out.println("Employee ID: | " + rs.getInt(1) + " First Name: | " + rs.getString(2)
									+ " Last Name: | " + rs.getString(3) + " Email: | " + rs.getString(4) + " Address: "
									+ rs.getString(5));
						}
					}

					break;

				default:
					System.out.println("Sorry! It seems you have entered in a wrong input. Please try again!");
					break;
				} // end switch
			} // end while
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch

	} // end main

} // end JDBCAssignment Class
