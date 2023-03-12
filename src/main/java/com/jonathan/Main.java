package com.jonathan;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int opc = 0;
		    Usuario usu = new Usuario();
		    
		    
		    // MENU DE OPÇÔES
		    JOptionPane.showMessageDialog(null, "Informe o como deseja procurar um usuario");
		    while(opc != 9) {
		    	opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção sendo"
		    			+ " \n 1-procurar por id "
		    			+ "\n 2-procurar por nome "));
		    	switch(opc) {
		    	case 1:
		    		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do usuario"));
		    		usu.obtemDadoPorId(id);
		    		break;
		    	case 2:
		    		String nome = JOptionPane.showInputDialog("Informe o nome que deseja pesquisar");
		    		usu.obtemDadoPorNome(nome);
		    		break;
		    	default:
		    		JOptionPane.showMessageDialog(null, "Usuario digitado ERRADO");
		    		break;
		    	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	}
	}
