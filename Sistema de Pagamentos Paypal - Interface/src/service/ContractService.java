package service;

import entities.Contract;
import entities.Parcelas;

import java.util.Calendar;
import java.util.Date;

//import application.Payment_PayPal;




      public class ContractService {

            private Online_Payment_Service online_Payment_Service;
            private Date date;

            //----------------------------
            //!       CONSTRUCTOR
            //----------------------------

            public ContractService(Online_Payment_Service online_Payment_Service) {
                  this.online_Payment_Service = online_Payment_Service;
            }

            

            public void processContract(Contract contract, int months) {
                  double basicAlicota = contract.getTotalValue() / months;
                  for (int i = 1; i <= months; i++) {
                        double updateQuota = basicAlicota + online_Payment_Service.juros(basicAlicota, i);
                        double Cota_Maxima = updateQuota + online_Payment_Service.taxa_Juros(updateQuota);
                        contract.addParcelas(new Parcelas(date, Cota_Maxima));
                  }
            }

            //%%---------->>> Método para adicionar meses a uma data
            private Date addMonths(Date date, int n) {
                  Calendar cal = Calendar.getInstance();
                  cal.setTime(date);
                  cal.add(Calendar.MONTH, n);
                  return cal.getTime();
            }

      }

   

