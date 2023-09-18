import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 /*
   Diariamente, muchas botellas reciclables de plástico y vidrio son desechadas y terminan en vertederos
   de basura en lugar de ser recicladas adecuadamente. Para abordar este problema, se propone una solución
   en la que las tiendas o supermercados de cadena incentiven a los clientes a reciclar estas botellas.
   La idea es que las personas reciban un pago o incentivo por llevar botellas reciclables a estos establecimientos
   para su posterior reciclaje.

   Para la solucion se debe de tener encuenta un algoritmo que realice las siguientes tareas:

    1.Buscar en el sistema si un cliente esta registrado
    y mostrar si esta esta reciclando o no

    2.Mostrar lo siguiente
      -Numero de personas que reciclan
      -Numero depersonas que no reciclan
      -El numero de mujeres
      -El numerode hombres
      -El porcentaje de mujeres que reciclan


    3. Se requiere saber cual es  la persona que mas botellas ha reciclado

    4.Si por cada botella reciclada se va a pagar 100 pesos
       -Mostrar cuanto dinero tiene cada cliente por pago de lasbotellas

    5.Si los grupos de personas se clasifican en : jovenes de 18 a 27 años,
    adultos de 28 a 59 años y adultos mayores de 60 en adelane.

    - Mostar cuantas personas hay por cada grupo y cuantas reciclan

    6. Mostrar el numero de botellas recicladas por año

    */

public class ProyectoUno {
    record  customerInformation(String name,
                              String surname,
                              Integer age,
                              Character gender,
                              String id,
                              boolean recycle,
                              int numberBottles,
                              LocalDate recyclinStartDate
                              ){}
    public static void main(String[] args) {

        List<customerInformation>  customerData= new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        customerData.add(new customerInformation("Marta","Gonzales",24,'F',"182",true,13,LocalDate.parse("15/03/2021", formatter)  ));
        customerData.add(new customerInformation("Marti","Alvares",32,'M',"273",true,28,LocalDate.parse("07/09/2020", formatter)  ));
        customerData.add(new customerInformation("Juana","Martines",45,'F',"364",false,0,null));
        customerData.add(new customerInformation("Estafania","Gonzales",36,'F',"451",true,38,LocalDate.parse("24/10/2021", formatter)  ));
        customerData.add(new customerInformation("Esteban","Colorado",62,'M',"512",false,0,null  ));
        customerData.add(new customerInformation("Angela","Fuentes",19,'F',"645",true,6,LocalDate.parse("15/01/2020", formatter)  ));
        customerData.add(new customerInformation("Camilo","Conrrado",70,'M',"736",false,0,null  ));
        customerData.add(new customerInformation("Luisa","Conrrado",21,'F',"827",false,0,null  ));
        customerData.add(new customerInformation("Carlos","Ochoa",31,'M',"918",true,19,LocalDate.parse("15/12/2023", formatter)  ));
        customerData.add(new customerInformation("Juan","Fuentes",52,'M',"192",true,12,LocalDate.parse("15/06/2023", formatter)  ));
        customerData.add(new customerInformation("Camila","Martines",55,'F',"283",false,0,null  ));
        customerData.add(new customerInformation("Susana","Zapata",28,'F',"374",true,26,LocalDate.parse("15/03/2023", formatter)  ));
        customerData.add(new customerInformation("Diana","Nuñes",25,'F',"371",false,0,null  ));
        customerData.add(new customerInformation("Alfonso","Alvares",42,'M',"372",true,30,LocalDate.parse("15/03/2023", formatter)  ));
        customerData.add(new customerInformation("Samara","Martinez",61,'F',"373",true,25,LocalDate.parse("15/03/2022", formatter)  ));
        customerData.add(new customerInformation("Sebastian","Gutierrez",23,'M',"375",false,0,null ));
        customerData.add(new customerInformation("Alejandra","Gonzales",58,'F',"376",true,12,LocalDate.parse("15/03/2022", formatter)  ));
        customerData.add(new customerInformation("Sergio","Ochoa",66,'M',"377",true,19,LocalDate.parse("15/03/2020", formatter)  ));
        customerData.add(new customerInformation("Yane","Fernandez",19,'F',"378",false,0,null ));
        customerData.add(new customerInformation("Yovani","zAPATA",30,'M',"379",true,9,LocalDate.parse("15/03/2022", formatter)  ));

        System.out.println("-----------------------------1-----------------------------------");
        String idSearching= "182";
        int i=0;
        while(i< customerData.size()){
            customerInformation customer= customerData.get(i);
            if(customer.id().equals(idSearching)){
                System.out.println("The customer with id:  "+ idSearching+
                        " Is register and its recycling status  "+customer.recycle );
                break;
            }else {
                System.out.println("The customer with id "+ idSearching+ " Is not register");
            }
        }

        System.out.println("-------------------------------2---------------------------------");

        int numberWomen=0;
        int numberMan=0;
        int numberWomenRecycle=0;
        int numberManRecycle=0;

        for (customerInformation customer:customerData){
            if( customer.gender == 'F'){
                numberWomen ++;
            }
            if(customer.gender == 'M'){
                numberMan++;
            }

            if(customer.recycle() &&  customer.gender == 'F'){
                numberWomenRecycle ++;
            }

            if(customer.recycle() &&  customer.gender == 'M'){
                numberManRecycle ++;
            }
        }

        int numberPersonRecyclin=numberWomenRecycle + numberManRecycle;
        int numberPersonNoRecyclin=(numberWomen + numberMan) - numberPersonRecyclin;
        double percentageWomenRecycle=(double) numberWomenRecycle * 100 /numberWomen;

        System.out.println(" The number of customer that recycli is "+ numberPersonRecyclin);
        System.out.println(" The number of customer that not recycli is "+ numberPersonNoRecyclin);
        System.out.println(" The numbers of women is "+ numberWomen);
        System.out.println(" The numbers of men is "+ numberMan);
        System.out.println(" The number of women that recycli is "+ numberWomenRecycle);
        System.out.println(" The number of men that  recycli is "+ numberManRecycle);
        System.out.println(" The persentage women that recycli is "+ percentageWomenRecycle +" %");

        System.out.println("------------------------------3----------------------------------");

        String nameCustomer= "";
        String  surnameCustomer="";
        int numberBottles=0;

        for (customerInformation customer:customerData){
            if (customer.numberBottles > numberBottles ){
                nameCustomer=customer.name;
                surnameCustomer=customer.surname;
                numberBottles=customer.numberBottles;
            }
        }

        System.out.println(" The customer who recycles the most is " +nameCustomer +
                " "+ surnameCustomer+ " With " + numberBottles + " bottles");

        System.out.println("----------------------------4------------------------------------");

        double monyForCustomer=0;
        double monyForbattle=100;

        for ( customerInformation customer: customerData){
            monyForCustomer=customer.numberBottles() * monyForbattle;
            System.out.println(customer.name + " "+ customer.surname+ " Have "+ monyForCustomer+ "$");
        }

        System.out.println("-------------------------------5---------------------------------");

        int youngPeople=0;
        int adultPeople=0;
        int oldPeople=0;
        int youngRecyclers = 0;
        int adultRecyclers = 0;
        int oldRecyclers = 0;


        for(customerInformation customer:customerData){
            if(customer.age >= 18 && customer.age <=27){
                if(customer.recycle){
                    youngRecyclers ++;
                }
                youngPeople++;
            } else if (customer.age >= 28 && customer.age <=59  ) {
                if(customer.recycle){
                    adultRecyclers ++;
                }
                adultPeople ++;
            } else if (customer.age >= 60 ) {
                if(customer.recycle){
                    oldRecyclers ++;
                }
                oldPeople ++;
            }
        }

        System.out.println("There are "+youngPeople+ " young people and recycle "+ youngRecyclers);
        System.out.println("There are "+adultPeople+" adults people and recycle "+adultRecyclers);
        System.out.println("There are "+oldPeople+" old people and recycle "+oldRecyclers);


        System.out.println("-----------------------------6-----------------------------------");

        Map<Integer, Integer>    bottlesRecycledYears = new HashMap<>();

        for (customerInformation customer : customerData) {
            if (customer.recyclinStartDate != null) {
                int year = customer.recyclinStartDate.getYear();
                int bottlesRecycled = customer.numberBottles;

                if (bottlesRecycledYears.containsKey(year)) {
                    bottlesRecycled += bottlesRecycledYears.get(year);
                }

                bottlesRecycledYears.put(year, bottlesRecycled);
            }
        }


        for (Map.Entry<Integer, Integer> numberBottlesYears : bottlesRecycledYears.entrySet()){

            System.out.println("Year "+numberBottlesYears.getKey()+" Bottles recycle "+numberBottlesYears.getValue());
        }
    }
}
