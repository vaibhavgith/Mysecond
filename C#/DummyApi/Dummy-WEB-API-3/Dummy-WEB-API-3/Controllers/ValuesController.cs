using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Text;

namespace Dummy_WEB_API_3.Controllers
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

        [HttpPost("create")]
        public async Task<IActionResult> CreateEmployee([FromBody] CreateEmployeeRequest request)
        {
            try
            {
                var client = _clientFactory.CreateClient();

                // Serialize the request object to JSON
                var content = new StringContent(JsonConvert.SerializeObject(request), Encoding.UTF8, "application/json");

                // Make a POST request to the external API
                var response = await client.PostAsync("https://dummy.restapiexample.com/api/v1/create", content);

                if (response.IsSuccessStatusCode)
                {
                    var responseContent = await response.Content.ReadAsStringAsync();
                    var createdEmployee = JsonConvert.DeserializeObject<CreateEmployeeResponse>(responseContent);
                    return Ok(createdEmployee);
                }
                else
                {
                    return StatusCode((int)response.StatusCode, "Failed to create employee.");
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
    }
}
