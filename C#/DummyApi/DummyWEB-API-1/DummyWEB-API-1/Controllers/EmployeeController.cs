using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;
using DummyWEB_API_1.Model;

[Route("api/[controller]")]
[ApiController]
public class EmployeeController : ControllerBase
{
    private readonly IHttpClientFactory _clientFactory;

    public EmployeeController(IHttpClientFactory clientFactory)
    {
        _clientFactory = clientFactory;
    }

    [HttpGet]
    public async Task<IActionResult> GetEmployees()
    {
        try
        {
            var client = _clientFactory.CreateClient();

            // Make a GET request to the external API to retrieve employees
            var response = await client.GetAsync("https://dummy.restapiexample.com/api/v1/employees");

            if (response.IsSuccessStatusCode)
            {
                var responseContent = await response.Content.ReadAsStringAsync();
                // Deserialize the response as an EmployeeApiResponse
                var employeeResponse = Newtonsoft.Json.JsonConvert.DeserializeObject<EmployeeApiResponse>(responseContent);

                // Access the list of employees from the "data" property
                var employees = employeeResponse.data;

                return Ok(employees);
            }
            else
            {
                return StatusCode((int)response.StatusCode, "Failed to retrieve employees.");
            }
        }
        catch (Exception ex)
        {
            return StatusCode(500, "Internal server error: " + ex.Message);
        }
    }
}
