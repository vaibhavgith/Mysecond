using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Text;

namespace DummyWEB_API_4.Controllers
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

        [HttpPut("update/{employeeId}")]
        public async Task<IActionResult> UpdateEmployee(int employeeId, [FromBody] UpdateEmployeeRequest request)
        {
            try
            {
                var client = _clientFactory.CreateClient();

                // Serialize the request object to JSON
                var content = new StringContent(JsonConvert.SerializeObject(request), Encoding.UTF8, "application/json");

                // Make a PUT request to the external API to update the employee
                var response = await client.PutAsync($"https://dummy.restapiexample.com/api/v1/update/{employeeId}", content);

                if (response.IsSuccessStatusCode)
                {
                    var responseContent = await response.Content.ReadAsStringAsync();
                    var updatedEmployee = JsonConvert.DeserializeObject<UpdateEmployeeResponse>(responseContent);
                    return Ok(updatedEmployee);
                }
                else
                {
                    return StatusCode((int)response.StatusCode, "Failed to update employee.");
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
    }
}
