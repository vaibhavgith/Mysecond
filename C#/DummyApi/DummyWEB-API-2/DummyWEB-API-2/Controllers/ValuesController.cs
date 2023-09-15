using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace DummyWEB_API_2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeeController : ControllerBase
    {
        private readonly IHttpClientFactory _clientFactory;

        public EmployeeController(IHttpClientFactory clientFactory)
        {
            _clientFactory = clientFactory;
        }

        [HttpGet("employee/{employeeId}")]
        public async Task<IActionResult> GetEmployee(int employeeId)
        {
            try
            {
                var client = _clientFactory.CreateClient();

                // Make a GET request to the external API to retrieve employee details
                var response = await client.GetAsync($"https://dummy.restapiexample.com/api/v1/employee/{employeeId}");

                if (response.IsSuccessStatusCode)
                {
                    var responseContent = await response.Content.ReadAsStringAsync();
                    // Deserialize the response content into your employee model
                    // Replace EmployeeModel with the actual model you use
                    var employee = Newtonsoft.Json.JsonConvert.DeserializeObject<EmployeeModel>(responseContent);
                    return Ok(employee);
                }
                else
                {
                    return StatusCode((int)response.StatusCode, "Failed to retrieve employee details.");
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
    }
}
