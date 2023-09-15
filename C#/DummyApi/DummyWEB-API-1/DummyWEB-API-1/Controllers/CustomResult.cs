using System.Net;
using System.Net.Http;
using System.Net.Http.Formatting;

namespace DummyWEB_API_1.Controllers
{
    public class CustomActionResult<T> : IHttpActionResult
    {
        private readonly T content;
        private readonly HttpStatusCode statusCode;

        public CustomActionResult(T content, HttpStatusCode statusCode)
        {
            this.content = content;
            this.statusCode = statusCode;
        }

        public Task<HttpResponseMessage> ExecuteAsync(CancellationToken cancellationToken)
        {
            HttpResponseMessage response = new HttpResponseMessage(statusCode)
            {
                Content = new ObjectContent<T>(content, new JsonMediaTypeFormatter()),
            };

            return Task.FromResult(response);
        }
    }

}
