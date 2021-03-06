package com.coder.jaxb.xml;

public class JaxbCodeGenerationDemo {/*
	private static final String XML_FILE = "education_centers.xml";

	public static void main(String[] args) throws JAXBException, FileNotFoundException {

		List<Student> students = new ArrayList<Student>();

		Student s1 = new Student();
		s1.setFirstName("Alan");
		s1.setLastName("Turing");
		s1.setSection("Computer Science");
		s1.setBirthDate(new LocalDate(1956, 10, 1));
		s1.setId(1);
		students.add(s1);

		Student s2 = new Student();
		s2.setFirstName("Thomas");
		s2.setLastName("Edison");
		s2.setSection("Physics");
		s2.setBirthDate(new LocalDate(1916, 3, 3));
		s2.setId(2);
		students.add(s2);

		Student s3 = new Student();
		s3.setFirstName("Linus");
		s3.setLastName("Torvald");
		s3.setSection("Computer Science");
		s3.setBirthDate(new LocalDate(1958, 11, 4));
		s3.setId(3);
		students.add(s3);

		University university = new University();
		university.setName("Cambridge");
		university.setAddress("England");
		University.Students stds = new University.Students();
		stds.getStudent().addAll(students);
		university.setStudents(stds);

		// create JAXB context
		JAXBContext context = JAXBContext.newInstance(University.class);

		System.out.println("<!----------Generating the XML Output-------------->");

		// Marshalling [Generate XML from JAVA]
		// create Marshaller using JAXB context
		Marshaller m = context.createMarshaller();
		// To format the [to be]generated XML output
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Marshall it and write output to System.out or to a file
		m.marshal(university, System.out);
		m.marshal(university, new File(XML_FILE));

		System.out.println("<!---------------Generating the Java objects from XML Input-------------->");
		// UnMarshalling [Generate JAVA from XML]
		// Instantiate Unmarshaller via context
		Unmarshaller um = context.createUnmarshaller();
		// Unmarshall the provided XML into an object
		University unif = (University) um.unmarshal(new FileReader(XML_FILE));
		List<Student> studentsList = unif.getStudents().getStudent();
		for (Student s : studentsList) {
			System.out.println("Student : " + s);
		}
	}

*/}
