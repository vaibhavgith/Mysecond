using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Text;

namespace DummyWEB_API_5.Controllers
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

        [HttpDelete("delete/{employeeId}")]
        public async Task<IActionResult> DeleteEmployee(int employeeId)
        {
            try
            {
                var client = _clientFactory.CreateClient();

                // Make a DELETE request to the external API to delete the employee
                var response = await client.DeleteAsync($"https://dummy.restapiexample.com/api/v1/delete/{employeeId}");

                if (response.IsSuccessStatusCode)
                {
                    // Employee deleted successfully
                    return Ok("Employee deleted successfully.");
                }
                else
                {
                    return StatusCode((int)response.StatusCode, "Failed to delete employee.");
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
    }
}
