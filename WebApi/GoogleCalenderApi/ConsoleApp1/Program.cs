using Google.Apis.Calendar.v3;
using Google.Apis.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Program
    {
        const string ApiKey = "AIzaSyDBUjoLkgyGrJk2ar1cr4GNniDXvrbO77s";
        const string CalenderId = "en.indian#holiday@group.v.calendar.google.com";
        static async Task Main(string[] args)
        {
            Console.WriteLine("Heloow");

            var service = new CalendarService(new BaseClientService.Initializer()
            {
                ApiKey = ApiKey,
                ApplicationName = "Api key Example"

            });

            var request = service.Events.List(CalenderId);
            request.Fields = "Item(summary,start,end)";
            var response = await request.ExecuteAsync();


            foreach (var item in response.Items)
            {
                Console.WriteLine($"Holiday:{item.Summary} start: {item.Start} end: {item.End}");
            }
            Console.ReadLine();

        }
    }
}