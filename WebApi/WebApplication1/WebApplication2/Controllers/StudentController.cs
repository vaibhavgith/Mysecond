using DocumentFormat.OpenXml.Office2010.Excel;
using DocumentFormat.OpenXml.Wordprocessing;
using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {


        [HttpGet]
        public IEnumerable<Students> GetStudents()
        {
            return ClassR.Pepole;
        }
        // [HttpGet("{id:int}")]
        //  public Students GetStudentsById(int id)
        //  {
        //      return ClassR.Pepole.Where(n => n.Id == id).FirstOrDefault();
        // }

        [HttpGet]
        [Route("{id}",Name ="GetById")]
        public Students GetStudentById(int id)
        {
            return ClassR.Pepole.Where(n =>n.Id== id).FirstOrDefault();
        }
        [HttpGet("{name}")]
        public Students GetStudentByName(string name)
        {
            return ClassR.Pepole.Where(n => n.StudentName == name).FirstOrDefault();
        }
        [HttpDelete]
        public bool DeleteStudent(int id)
        {
            var stu= ClassR.Pepole.Where(n => n.Id == id).FirstOrDefault();
            ClassR.Pepole.Remove(stu);

            return true;
        }



    }



 }

   
