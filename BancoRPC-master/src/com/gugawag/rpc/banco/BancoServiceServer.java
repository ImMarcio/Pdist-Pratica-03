package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private ArrayList<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta("1", 100.0));
        contas.add(new Conta("2", 156.0));
        contas.add(new Conta("3", 950.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        double saldo = 0;
        for(Conta c : this.contas){
            if(c.numero.equals(conta)){
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarContar(String numero) throws RemoteException{
        contas.add(new Conta(numero, 0));
    }
    
    @Override
    public String pesquisarConta(String numero) throws RemoteException {
        String texto = "";
        for(Conta c : this.contas){
            if(c.numero.equals(numero)){
                texto = c.toString();
            }
        }
        return texto;
    }

    @Override
    public String removerConta(String numero) throws RemoteException{
      String texto = "";

      try {
        for(int i = 0; i < this.contas.size(); i++){
            if(contas.get(i).getNumero().equals(numero)){
                contas.remove(i);
                texto = "Conta Excluída!";
            }
          }
        
      } catch (Exception e) {
        texto = e.getMessage();
      }
   
      
      return texto;
       
    }



}
