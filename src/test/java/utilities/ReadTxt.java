package utilities;

import pojos.Registrant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {



    public static List<String> getSSNIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("database_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[0];
                list.add(ssn);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }

    public static List<String> getAppIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("database_appointments_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//IDs

            while(line != null){

                String AppID = line.split(",")[0];
                list.add(AppID);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }



    public static List<String> getAPISSNIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            //FileReader fileReader = new FileReader(ConfigurationReader.getProperty("api_all_registrant_data"));
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("appointment_API_records"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[2];
                list.add(ssn);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }
    public static List<String> getAPIAppointments(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location

            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("appointment_API_records"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while(line != null){

                String id = line.split(",")[2];
                list.add(id);
                String startDate = line.split(",")[3];
                list.add(startDate);
                String endDate = line.split(",")[4];
                list.add(endDate);
                String status = line.split(",")[5];
                list.add(status);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }

    public static List<String> getPhysicianAPI(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location

            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("physician_API_records"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while(line != null){

                String firstName = line.split(",")[0];
                list.add(firstName);
                String lastName = line.split(",")[1];
                list.add(lastName);
                String ssn = line.split(",")[2];
                list.add(ssn);


                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }
    public static List<String> getPhysicianUI(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location

            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("physician_data"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while(line != null){

                String firstName = line.split(",")[0];
                list.add(firstName);
                String lastName = line.split(",")[1];
                list.add(lastName);
                String ssn = line.split(",")[2];
                list.add(ssn);


                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }

    public static List<String> getPhysicianUI_DB(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location

            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("physician_data"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while(line != null){

                String firstName = line.split(",")[0];
                list.add(firstName);
                String lastName = line.split(",")[1];
                list.add(lastName);
//                String ssn = line.split(",")[2];
//                list.add(ssn);


                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }
    public static List<String> getPhysicianDB(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location

            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("database_physician_data"));
            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while(line != null){

                String firstName = line.split(",")[18];
                firstName=firstName.split("=")[1];
                list.add(firstName);
                String lastName = line.split(",")[4];
                lastName=lastName.split("=")[1];
                list.add(lastName);



                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }

    public static List<Registrant> getAllRegistrants(){
        List <Registrant > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("api_all_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){
                Registrant registrant = new Registrant();


                registrant.setFirstName(line.split(",")[0]);
                registrant.setLastName(line.split(",")[1]);
                registrant.setSsn(line.split(",")[2]);
                registrant.setLogin(line.split(",")[3]);
                if(line.split(",")[4] != null) {
                    String  id = line.split(",")[4];
                    boolean flag = true;
                    for(int i=0; i<id.length();i++){
                        if(id.charAt(i) >= '0' && id.charAt(i) <= '9'){
                            flag = true;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        registrant.setId(Integer.parseInt(line.split(",")[4]));
                }
                if(line.split(",")[5] != null)
                    registrant.setEmail(line.split(",")[5]);

                list.add(registrant);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }





}