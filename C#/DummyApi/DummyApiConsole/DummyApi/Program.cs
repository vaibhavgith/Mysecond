using System;
using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;
using System.Collections.Generic;

public class Employee
{
    public int id { get; set; }
    public string employee_name { get; set; }
    public int employee_salary { get; set; }
    public int employee_age { get; set; }
    public string profile_image { get; set; }
}

public class EmployeeResponse
{
    public string status { get; set; }
    public List<Employee> data { get; set; }
}

class Program
{
    static async Task Main(string[] args)
    {
        await GetEmployeesAsync();
    }

    static async Task GetEmployeesAsync()
    {
        string apiUrl = "https://dummy.restapiexample.com/api/v1/employees";

        using (HttpClient client = new HttpClient())
        {
            try
            {
                HttpResponseMessage response = await client.GetAsync(apiUrl);

                if (response.IsSuccessStatusCode)
                {
                    string responseBody = await response.Content.ReadAsStringAsync();

                    // Deserialize the JSON response into EmployeeResponse
                    EmployeeResponse employeeResponse = JsonConvert.DeserializeObject<EmployeeResponse>(responseBody);

                    if (employeeResponse != null && employeeResponse.data != null)
                    {
                        List<Employee> employees = employeeResponse.data;

                        // Display employee information in a tabular format
                        Console.WriteLine("| Employee ID | Employee Name | Employee Salary | Employee Age |");
                        Console.WriteLine("|-------------|---------------|-----------------|--------------|");
                        foreach (var employee in employees)
                        {
                            Console.WriteLine($"| {employee.id,-11} | {employee.employee_name,-13} | {employee.employee_salary,-15} | {employee.employee_age,-10} |");
                        }
                    }
                    else
                    {
                        Console.WriteLine("No employee data found in the response.");
                    }
                }
                else
                {
                    Console.WriteLine("Failed to retrieve data. Status code: " + response.StatusCode);
                }
            }
            catch (HttpRequestException e)
            {
                Console.WriteLine("Request error: " + e.Message);
            }
            Console.ReadKey();
        }
    }
}
