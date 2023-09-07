namespace WebApplication2.Models
{
    public  static class ClassR
    {
        public static List<Students>Pepole { get; set; }= new List<Students>() {
                new Students
                {

                    Id = 1,
                    StudentName = "Test",
                    StudentEmail = "Test",
                    StudentPhone = "Test",


                 },
               new Students {
                     Id = 2,
                    StudentName = "Tesst",
                    StudentEmail = "Tesst",
                    StudentPhone = "Tesst",


                }



             };

    }
}
