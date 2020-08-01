package implementacion;

import java.util.Scanner;

import clases.*;
import gestionClases.*;
import utileria.AdminFechas;
import java.util.Date;
import java.util.LinkedList;

public class implimentacion {

	public static void main(String[] args) {
		
		//instancia de Scanner
		Scanner sc = new Scanner(System.in);
		Scanner scnum = new Scanner(System.in);
		
		//variables
		String nombre, apellido, direccion, telefono, rtn, correoElectronico, empresa, usuario = null, usuarioConfir, constrasena = null, constrasenaconfirm;
		String codigoReferencia, nombreReferencia, apellidoreferencia, fechaNacimiento, 
		direccionreferencia, telefonoreferencia, rtnreferencia, correorefencia;
		byte opcionprincipal;
		
		boolean centinelaPrincipal = true;
		
		//GESTIONES QUE HEREDAN DE PERSONA
		GestionUsuario gestionUsuario = new GestionUsuario();
		GestionReferencia gestionRefencia = new GestionReferencia();
		
		//GESTIONES DE CUENTAS BANCARIAS
		GestionCuentaBancaria gestionCuentaBancaria = new GestionCuentaBancaria();
		GestionCuentaAhorro gestionCuentaAhorro = new GestionCuentaAhorro();
		GestionCuentaCheques gestionCuentaCheques = new GestionCuentaCheques();
		GestionCuentaCorrientePersonal gestionCuenCorrienteper = new GestionCuentaCorrientePersonal();
		GestionCuentaNomina gestionCuentaNomina = new GestionCuentaNomina();
		
		//GESTIONES DE TRANSFERENCIAS
		GestionTransferenciasACH gestionTACH = new GestionTransferenciasACH();
		GestionTransferenciasCuentasPropias gestionTECP = new GestionTransferenciasCuentasPropias();
		GestionTransferenciasTerceros gestionTT = new GestionTransferenciasTerceros();
		GestionTransferenciasInternacionales gestionTI = new GestionTransferenciasInternacionales();
		
		//GESTION DE SEGUROS
		GestionSeguroMedico gestionSeguroMedico = new GestionSeguroMedico();
		
		//COMPORTAMIENTO POLIMORFICO
		LinkedList<Persona> _listaPersona = new LinkedList<>();
		LinkedList<CuentaBancaria> _listaCuentasBancarias = new LinkedList<>();
		LinkedList<Transferencias> _listaTransferencias = new  LinkedList<>();
		LinkedList<Pagos> _listaPagos = new LinkedList<>();
		
		//LinkedList<ObtencionDatos> _listaDatosBancarios = new LinkedList<>();
		
		
		//INSTANCIA PARA REALIZAR IMPLEMETACION
		Referencia ref1 = new Referencia(gestionRefencia.getCodigoReferencia(),"Ana","Fuentes", AdminFechas.getFechaActual(),"TGU","98123412","1702200500123","AA@");
		Usuario titular = new Usuario(gestionUsuario.getCodigoUsuario(),AdminFechas.getFechaActual(),"Alex","Fuentes",
				                      AdminFechas.stringToDate("25-11-1999"),"TGU","98123412", "1702199900192","aaf@unah.hn","AAFM","1234", ref1);
		
		CuentaAhorro CuentaAhorros = new CuentaAhorro(titular, AdminFechas.getFechaActual(),"CUENTA DE AHORROS", 202012345, 20000 + gestionCuentaAhorro.interesRemunerados(20000) ,gestionCuentaAhorro.interesRemunerados(20000));
		CuentaCheques Cuentacheques = new CuentaCheques(titular, AdminFechas.getFechaActual(),"CUENTA DE CHEQUES", 202067890, 1000000 + gestionCuentaCheques.interesRemunerados(1000000), gestionCuentaCheques.interesRemunerados(1000000));
		
		
		_listaPersona.add(titular);
		_listaPersona.add(ref1);
		
		_listaCuentasBancarias.add(CuentaAhorros);
		_listaCuentasBancarias.add(Cuentacheques);
		
		gestionCuentaBancaria.agregarTipoCuenta(CuentaAhorros);
		gestionCuentaBancaria.agregarTipoCuenta(Cuentacheques);
		
		gestionCuentaAhorro.agregarCuentaAhorro(CuentaAhorros);
		gestionCuentaCheques.agregarCuentaCheques(Cuentacheques);
		gestionUsuario.agregarUsuario(titular);

		/*-----------------------------------------------------------------------------------------------------------*/
		/*-------------------------------------------------INICIO---------------------------------------------------*/
		/*---------------------------------------------------------------------------------------------------------*/
		
		while(centinelaPrincipal) {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1. REGISTRARSE.");
			System.out.println("2. INICIAR SESIÓN.");
			System.out.println("3. ELIMINAR TIPO DE CUENTA.");
			System.out.println("4. ELIMINAR USUARIO.");
			System.out.println("5. MODIFICAR USUARIO.");
			System.out.println("6. INFORMACIÓN PERSONAL Y TRANSACCIONES."); // POLIMORFISMOS
			System.out.println("7. SALIR.");
			opcionprincipal = scnum.nextByte();
			
			switch(opcionprincipal) {
			case 1: //REGISTRARSE
				byte opcionRegistro;
				boolean centinelaRegistro = true;
				Usuario Titular1 = new Usuario();
				
				while(centinelaRegistro) {
					System.out.println("MENU DE REGISTRO.");
					System.out.println("1. INGRESAR DATOS PERSONALES Y CREE UN NOMBRE DE USUARIO Y CONTRASEÑA.");
					System.out.println("2. INGRESE REFERENCIA.");
					System.out.println("3. CREE UN TIPO DE CUENTA BANCARIA.");
					System.out.println("5. SALIR.");
					opcionRegistro = scnum.nextByte();
					
						switch(opcionRegistro) {
						case 1: //INGRESE DATOS PERSONALES
							
								String CodUsuario = gestionUsuario.getCodigoUsuario();
								System.out.println("INGRESE DATOS PERSONALES.\n");
								System.out.printf("Codigo de Usuario: %s", CodUsuario + "\n");
								System.out.print("Nombres: ");
								nombre = sc.nextLine();
								System.out.print("Apellidos: ");
								apellido = sc.nextLine();
								System.out.print("Fecha de nacimiento (dd-MM-yyyy): ");
								fechaNacimiento = sc.nextLine();
								Date FechaNacimientoUsuario = AdminFechas.stringToDate(fechaNacimiento);
								System.out.print("Dirección: ");
								direccion = sc.nextLine();
								System.out.print("Telefono: ");
								telefono = sc.nextLine();
								System.out.print("RTN: ");
								rtn = sc.nextLine();
								System.out.print("Correo electronico: ");
								correoElectronico = sc.nextLine();
							
								//NOMBRE DE USUARIO Y CONSTRASEÑA
								boolean centinelaUsuario = true, centinelaContrasena = true;
							
								//CREAR NOMBRE DE USUARIO
								System.out.println("\nCREE NOMBRE DE USUARIO Y CONTRASEÑA.\n");
								while(centinelaUsuario) {
								System.out.print("Usuario: ");
								usuario = sc.nextLine();
								
								System.out.print("Confirmar Usuario: ");
								usuarioConfir = sc.nextLine();
								
								if(gestionUsuario.confirmar(usuario, usuarioConfir)) {
									System.out.println("Nombre de usuario creado correctamente.");
									centinelaUsuario = false;
								}else {
									System.out.println("Los nombres de usuario no coinciden.");
								}
								}//FIN DE CODIGO PARA CREAR NOMBRE DE USUARIO
							
								//CREAR CONTRASEÑA
								System.out.println("\nCree una contraseña. \n");
								while(centinelaContrasena) {
									System.out.print("Contraseña: ");
									constrasena = sc.nextLine();
								
									System.out.print("Confirmar contraseña: ");
									constrasenaconfirm = sc.nextLine();
									
									if(gestionUsuario.confirmar(constrasena, constrasenaconfirm)) {
										System.out.println("Contraseña creada con exito\n");
										centinelaContrasena = false;
									}else {
										System.out.println("Las constraseñas no coinciden.\n");
									}
								}//FIN DE CODIGO PARA CREAR CONTRASEÑA
							
								Titular1.set_codigoUsuario(CodUsuario);
								Titular1.set_fechaRegistro(AdminFechas.getFechaActual());
								Titular1.set_apellido(apellido);
								Titular1.set_nombre(nombre);
								Titular1.set_fechaNacimiento(FechaNacimientoUsuario);
								Titular1.set_direccion(direccion);
								Titular1.set_telefono(telefono);
								Titular1.set_rtn(rtn);
								Titular1.set_correoelectronico(correoElectronico);
								Titular1.set_nombreUsuario(usuario);
								Titular1.set_contrasena(constrasena);
							
								if(gestionUsuario.agregarUsuario(Titular1)) {
									System.out.println("DATOS DEL USUARIO AGREGADO CORRECTAMENTE.\n");
								} else {
									System.out.println("EL USUARIO YA EXISTE.\n");
								}
							
							break;//FIN DE CODIGO PARA AGREGAR USUARIO O TITULAR
						case 2: //INGRESE REFERENCIA.
							
								codigoReferencia = gestionRefencia.getCodigoReferencia();
								System.out.println("INGRESE REFERENCIA.");
								System.out.printf("Codigo de refererencia: %s", codigoReferencia +"\n");
								System.out.print("Nombres: ");
								nombreReferencia = sc.nextLine();
								System.out.print("Apellidos: ");
								apellidoreferencia = sc.nextLine();
								System.out.print("Fecha de nacimiento (dd-MM-yyyy): ");
								fechaNacimiento = sc.nextLine();
								Date FechaNacimientoReferencia = AdminFechas.stringToDate(fechaNacimiento);
								System.out.print("Dirección: ");
								direccionreferencia = sc.nextLine();
								System.out.print("Telefono: ");
								telefonoreferencia = sc.nextLine();
								System.out.print("RTN: ");
								rtnreferencia = sc.nextLine();
								System.out.print("Correo electronico: ");
								correorefencia = sc.nextLine();
								
								Referencia referencia1 = new Referencia(codigoReferencia, nombreReferencia, apellidoreferencia,
										FechaNacimientoReferencia , direccionreferencia, telefonoreferencia, 
										rtnreferencia, correorefencia);
								
								if(gestionRefencia.agregarReferencia(referencia1)) {
									Titular1.set_referencia(referencia1);
									_listaPersona.add(Titular1);
									System.out.println("REFERENCIA AGREGADA CON EXITO.\n");
									//System.out.println(referencia1);
								}else {
									System.out.println("ERROR AL AGREGAR REFERENCIA.\n");
								 }
								
							break;//FIN DE CODIGO PARA AGREGAR REFERENCIA
							
						case 3: //CREE UN TIPO DE CUENTA BANCARIA.
							
								boolean centinelatipocuenta = true;
								byte opciontipoCuenta, opcion1;
								double montoInicial = 0, interesRemunerado; 
								int NumCuenta;
							
								while(centinelatipocuenta) {
									System.out.println("CREE UN TIPO DE CUENTA BANCARIA.");
									System.out.println("1. CUENTA DE AHORRO.");
									System.out.println("2. CUENTA DE CHEQUES.");
									System.out.println("3. CUENTA CORRIENTE PERSONAL.");
									System.out.println("4. CUENTA DE NOMINA.");
									opciontipoCuenta = scnum.nextByte();
									
										switch(opciontipoCuenta) {
										case 1: //CUENTA DE AHORRO.
											
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1 ) {
											
												System.out.println("APERTURA DE CUENTA DE AHORRO\n");
												System.out.print("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												interesRemunerado = gestionCuentaAhorro.interesRemunerados(montoInicial);
												NumCuenta = gestionCuentaBancaria.generaNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaAhorro cuentaAhorro1 = new CuentaAhorro(Titular1, AdminFechas.getFechaActual(),"CUENTA DE AHORRO", NumCuenta,
														montoInicial + interesRemunerado, interesRemunerado);
												
												if(gestionCuentaAhorro.agregarCuentaAhorro(cuentaAhorro1) && gestionCuentaBancaria.agregarTipoCuenta(cuentaAhorro1)) {
													System.out.println("CUENTA DE AHORRO CREADA EXITOSAMENTE.\n");
													//System.out.println(cuentaAhorro1);
													_listaCuentasBancarias.add(cuentaAhorro1);
													
												 }else {
													System.out.println("ERROR AL CREAR CUENTA DE AHORRO.\n");
													break;
												 }
												
												} else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE AHORRO.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											break;//CODIGO PARA AGREGAR CUENTA DE CHEQUES
											
										case 2: //CUENTA DE CHEQUES
											
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1 ) {
												
												System.out.println("APERTURA DE CUENTA DE CHEQUES\n");
												System.out.print("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												interesRemunerado = gestionCuentaCheques.interesRemunerados(montoInicial);
												NumCuenta = gestionCuentaBancaria.generaNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaCheques cuentachques1 = new CuentaCheques(Titular1, AdminFechas.getFechaActual(),"CUENTA DE CHEQUES", 
														NumCuenta, montoInicial + interesRemunerado, interesRemunerado);
												
												if(gestionCuentaCheques.agregarCuentaCheques(cuentachques1) && gestionCuentaBancaria.agregarTipoCuenta(cuentachques1)) {
														System.out.println("CUENTA DE CHEQUES CREADA EXITOSAMENTE.\n");
														//System.out.println(cuentachques1);
														_listaCuentasBancarias.add(cuentachques1);
													}else {
														System.out.println("ERROR AL CREAR CUENTA DE CHEQUES.\n");
														break;
													}
					
												} else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE CHEQUES.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											break; //FIN DE CODIGO PARA CREAR CUENTA DE DE CHEQUES
											
										case 3: // CUENTA CORRIENTE PERSONAL
											
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1) {
												
												System.out.println("APERTURA DE CUENTA CORRIENTE PERSONAL\n");
												System.out.print("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												
												NumCuenta = gestionCuentaBancaria.generaNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaCorrientePersonal cuentaCorrientepers1 = new CuentaCorrientePersonal(Titular1, AdminFechas.getFechaActual(),
														"CUENTA CORRIENTE PERSONALA", NumCuenta, montoInicial);
												
												if(gestionCuenCorrienteper.AgregarCuentaCorrientePersonal(cuentaCorrientepers1) && gestionCuentaBancaria.agregarTipoCuenta(cuentaCorrientepers1)) {
														System.out.println("CUENTA CORRIENTE PERSONAL CREADA EXITOSAMENTE.\n");
														//System.out.println(cuentaCorrientepers1);
														_listaCuentasBancarias.add(cuentaCorrientepers1);
													}else {
														System.out.println("ERROR AL CREAR CUENTA CORRIENTE PERSONAL.\n");
														break;
													}	
												
												} else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE CHEQUES.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											
											break; //FIN CODIGO PARA AGREGAR CUENTA CORRIENTE PERSONAL
											
										case 4: //CUENTA DE NOMINA
											
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1) {
												
												System.out.println("APERTURA DE CUENTA DE NOMINA\n");
												System.out.print("Ingrese la empresa depositante:");
												empresa = sc.nextLine();
												NumCuenta = gestionCuentaBancaria.generaNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaNomina cuentaNomina1 = new CuentaNomina(Titular1, AdminFechas.getFechaActual(), "CUENTA DE NOMINA", 
														NumCuenta, 0, empresa);
												
												if(gestionCuentaNomina.agregarCuentaNomina(cuentaNomina1) && gestionCuentaBancaria.agregarTipoCuenta(cuentaNomina1)) {
														System.out.println("CUENTA DE NOMINA CREADA EXITOSAMENTE.\n");
														//System.out.println(cuentaNomina1);
														_listaCuentasBancarias.add(cuentaNomina1);
													}else {
														System.out.println("ERROR AL CREAR CUENTA DE NOMINA.\n");
														break;
													}

												 } else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE CHEQUES.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											break;
											
											default:
												System.out.println("OPCIÓN NO VALIDA.");
												break;
										
										}// FIN DE SWITCH
										
									System.out.println("¿DESEA AGREGAR OTRO TIPO DE CUENTA?\n1. SI\n2. NO");
									opcion1 = scnum.nextByte();
									if(opcion1 == 2) {
										centinelatipocuenta = false;
									}
								}//FIN DEL WHILE PARA APERTURA DE CUENTAS
							
							break;
							
						case 5: //SALIR
							centinelaRegistro = false;
							break;
						}
				}//fin de registro Usuario
				
				/*
				if(gestionUsuario.AgregarUsuario(usuario1)) {
					System.out.println("ERROR AL REGISTRAR USUARIO\n");
				}else {
					System.out.println("USUARIO REGISTRADO CORRECTAMENTE.\n");
				}*/
				
				//gestionUsuario.imprimirTodos();
				//System.out.println(Titular1);
				
				break;
			case 2: //INICIAR SESIÓN
				byte opcion3, opcionmenuIS;
				boolean centinelaIniciosecion = true;
				System.out.println("MENU INICIAR SESECIÓN");
				
				while(centinelaIniciosecion) {
					System.out.println("1. INGRESAR USUARIO Y CONSTRASEÑA.");
					System.out.println("2. SALIR.");
					opcionmenuIS = scnum.nextByte();
					
						switch(opcionmenuIS) {
						case 1:
							boolean centinelaIS = true;
							String contrasena;
							
							
							while(centinelaIS) {
								System.out.println("INGRESE SU NOMBRE DE USUARIO:");
								usuario = sc.nextLine();
								System.out.println("INGRESE SU CONTRASEÑA:");
								contrasena = sc.nextLine();
								
								if(gestionUsuario.buscarNombreUsuario(usuario) && gestionUsuario.buscarcontrasena(contrasena)) {
									centinelaIS = false;
								}else {
									System.out.println("Usuario y contraseña incorrecto o Usuario no registrado.");
									break;
								}
								
								byte opcionTransferencias, opcionmenuTrans;
								boolean centinenlamenutrasn = true;
								double monto, interesRemunerado;
								int numCuenta;
								byte opcion;
								
								while(centinenlamenutrasn) {
									System.out.println("MENU DE OPERACIONES BANCARIAS");
									System.out.println("1. DEPOSITAR.");
									System.out.println("2. RETIRAR.");
									System.out.println("3. CONSULTAR SALDO.");
									System.out.println("4. Transferencias.");
									System.out.println("5. Pago de servicios.");
									System.out.println("6. salir.");
									System.out.println("Ingrese una de las opciones: ");
									opcionmenuTrans = scnum.nextByte();
									
									switch(opcionmenuTrans) {
									case 1: // DEPOSITAR
										
										System.out.println("Seleccione el tipo de cuenta en la que quiere depositar:");
										System.out.println("1. Cuenta de ahorro.");
										System.out.println("2. Cuenta de cheques.");
										System.out.println("3. Cuenta corriente personal.");
										opcion = scnum.nextByte();
										
										switch(opcion) {
										case 1: //Deposito en cuenta de ahorro
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaAhorro CtaAhorroBuscada = gestionCuentaAhorro.buscarCuentaAhorro(numCuenta);
											
											if(CtaAhorroBuscada != null) {
												System.out.print("Ingrese el monto a depositar:");
												monto = scnum.nextDouble();
												interesRemunerado = gestionCuentaAhorro.interesRemunerados(monto);
												CtaAhorroBuscada.set_interesremunerado(CtaAhorroBuscada.get_interesremunerado() + interesRemunerado);
												
												if(CtaAhorroBuscada.depositar(monto + interesRemunerado)) {
													System.out.println("Deposito realizado con exito.");
													System.out.println(CtaAhorroBuscada);
												}else {
													System.out.println("Error al realizar el deposito.");
												}
												
											}else {
												System.out.println("Cuenta no encontrada.");
											}
																																	
											break;
										case 2: //Depositos en cuenta de cheques
											
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaCheques CtaChequesBuscada = gestionCuentaCheques.buscarCuentaCheques(numCuenta);
											
											if(CtaChequesBuscada != null) {
												System.out.print("Ingrese el monto a depositar:");
												monto = scnum.nextDouble();
												interesRemunerado = gestionCuentaCheques.interesRemunerados(monto);
												CtaChequesBuscada.set_interesremunerado(CtaChequesBuscada.get_interesremunerado() + interesRemunerado);
												
												if(CtaChequesBuscada.depositar(monto + interesRemunerado)) {
													System.out.println("Deposito realizado con exito.\n");
													System.out.println(CtaChequesBuscada);
												}else {
													System.out.println("Error al realizar el deposito.\n");
												}
												
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											
											break;
										case 3: //Deposito en cuenta corriente personal
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaCorrientePersonal CtsCorrientePersonalBuscada = gestionCuenCorrienteper.buscarCuentaCorrientePersonal(numCuenta);
											
											if(CtsCorrientePersonalBuscada != null) {
												System.out.print("Ingrese el monto a depositar:");
												monto = scnum.nextDouble();
												
												if(CtsCorrientePersonalBuscada.depositar(monto)) {
													System.out.println("Deposito realizado con exito.\n");
												}else {
													System.out.println("Error al realizar el deposito.\n");
												}
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}

											break;
											
											default: //caso por defecto
												System.out.println("Opcion no valida.");
												break;
										}
										
										
										break;
									case 2: //RETIRAR
										
										System.out.println("Seleccione el tipo de cuenta en la que quiere retirar:");
										System.out.println("1. Cuenta de ahorro.");
										System.out.println("2. Cuenta de cheques.");
										System.out.println("3. Cuenta corriente personal.");
										System.out.println("4. Cuenta de nomina.");
										opcion = scnum.nextByte();
										
										switch(opcion) {
										case 1: //Retirar de cuenta de ahorro
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaAhorro CtaAhorroBuscada = gestionCuentaAhorro.buscarCuentaAhorro(numCuenta);
											
											if(CtaAhorroBuscada != null) {
												System.out.print("Ingrese el monto a retirar:");
												monto = scnum.nextDouble();
												
												if(CtaAhorroBuscada.retirar(monto)) {
													System.out.println("Retiro realizado con exito.");
													System.out.println(CtaAhorroBuscada);
												}else {
													System.out.println("Error al realizar el retiro.");
												}
												
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											
											
											break;
										case 2: //Retirar de cuenta de cheques
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaCheques CtaChequesBuscada = gestionCuentaCheques.buscarCuentaCheques(numCuenta);
											
											if(CtaChequesBuscada != null) {
												System.out.print("Ingrese el monto a retirar:");
												monto = scnum.nextDouble();
												
												if(CtaChequesBuscada.retirar(monto)) {
													System.out.println("Retirar realizado con exito.\n");
													System.out.println(CtaChequesBuscada);
												}else {
													System.out.println("Error al realizar el retirar.\n");
												}
												
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											
											break;
										case 3: //Retirar de cuenta corriente personal
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaCorrientePersonal CtsCorrientePersonalBuscada = gestionCuenCorrienteper.buscarCuentaCorrientePersonal(numCuenta);
											
											if(CtsCorrientePersonalBuscada != null) {
												System.out.print("Ingrese el monto a Retirar:");
												monto = scnum.nextDouble();
												
												if(CtsCorrientePersonalBuscada.retirar(monto)) {
													System.out.println("Retiro realizado con exito.\n");
												}else {
													System.out.println("Error al realizar el retiro.\n");
												}
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											
											break;
										case 4: //Retirar de cuenta de nomina
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaNomina CtaNominaBuscada = gestionCuentaNomina.buscarCuentaNomina(numCuenta);
											
											if(CtaNominaBuscada != null) {
												System.out.print("Ingrese el monto a retirar:");
												monto = scnum.nextDouble();
												
												if(CtaNominaBuscada.retirar(monto)) {
													System.out.println("Retiro realizado con exito.\n");
													System.out.println(CtaNominaBuscada);
												}else {
													System.out.println("Error al realizar el retiro.\n");
												}
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											
											
											break;
											
											default:
												System.out.println("Opción no valida.");
												break;
										}
										
										
										break;										
										
									case 3: // CONSULTAR SALDO
										
										System.out.println("Seleccione el tipo de cuenta en la que quiere retirar:");
										System.out.println("1. Cuenta de ahorro.");
										System.out.println("2. Cuenta de cheques.");
										System.out.println("3. Cuenta corriente personal.");
										System.out.println("4. Cuenta de nomina.");
										opcion = scnum.nextByte();
										
										switch(opcion) {
										
										case 1: //Consulta de saldo de cuenta de ahorro
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaAhorro CtaAhorroBuscada = gestionCuentaAhorro.buscarCuentaAhorro(numCuenta);
											
											if(CtaAhorroBuscada != null) {
												System.out.println("Su saldo es: " + CtaAhorroBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
										case 2: //consulta de saldo de cuenta de cheques
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaCheques CtaChequesBuscada = gestionCuentaCheques.buscarCuentaCheques(numCuenta);
											
											if(CtaChequesBuscada != null) {
												System.out.println("Su saldo es: " + CtaChequesBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
										case 3://Consulta de saldo de cuenta corriente personal
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaCorrientePersonal CtsCorrientePersonalBuscada = gestionCuenCorrienteper.buscarCuentaCorrientePersonal(numCuenta);
											
											if(CtsCorrientePersonalBuscada != null) {
												System.out.print("Su saldo es: " + CtsCorrientePersonalBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
										case 4://Consulta de saldo de cuenta de nomina
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = scnum.nextInt();
											
											CuentaNomina CtaNominaBuscada = gestionCuentaNomina.buscarCuentaNomina(numCuenta);
											
											if(CtaNominaBuscada != null) {
												System.out.println("Su saldo es: " + CtaNominaBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
											
											default:
												System.out.println("Opción no valida.");
												break;
												
												
										}//Fin de consulta de salfo
										
										
										break;
									case 4: //TRANSFERENCIAS
										
										String codtransferencia, tipomoneda = "", concepto,
										enviarConfirmacion, bancodestino;
										int cuentaDebitar, cuentaCreditar;
										double montoTransferir = 0;
										byte opcmoneda;
										
										System.out.println("Menu de transferencias.");
										System.out.println("1. Transferencias ACH (Bancos nacionales)");
										System.out.println("2. Transferencias entre Cuentas propias.");
										System.out.println("3. Transferencias a terceros. (en el mismo banco)");
										System.out.println("4. Transferencias internacionales.");
										System.out.print("Seleccione una de las opciones:");
										opcion = scnum.nextByte();
										
										switch(opcion) {
										
										case 1: //Transferencias ACH (Bancos nacionales)
											
											System.out.println("TRANSFERENCIAS ACH");
											codtransferencia = gestionTACH.getCodigoTACH();
											System.out.println("Codigo: " + codtransferencia);
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = scnum.nextInt();
											System.out.println("Seleccione el tipo de moneda: ");
											System.out.println("1. Lempiras.");
											System.out.println("2. Dolares");
											opcmoneda = scnum.nextByte();
											
											switch(opcmoneda) {
											case 1:
												tipomoneda = "Lempiras";
												break;
											case 2:
												tipomoneda = "Dolares";
												break;
												
												default:
													System.out.println("Opción no valida.\n");
													break;
											}
											
											System.out.print("Ingrese el número de cuenta a debitar: ");
											cuentaDebitar = scnum.nextInt();
													
											CuentaBancaria tipoCuenta7 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta7.get_numeroCuenta() == cuentaDebitar) {
												System.out.println("Ingrese el monto a transferir.");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta7.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											
											System.out.print("Banco destino: ");
											bancodestino = sc.nextLine();
											System.out.print("Concepto de transferencia: ");
											concepto = sc.nextLine();
											System.out.print("Enviar confirmación a: ");
											enviarConfirmacion = sc.nextLine();
											
											TransferenciasACH trasnferenciasACH = new TransferenciasACH(codtransferencia, tipomoneda,
													cuentaDebitar, cuentaCreditar, montoTransferir, bancodestino, concepto, enviarConfirmacion);
											
											if(gestionTACH.agregarTACH(trasnferenciasACH)) {
												System.out.println("Transferencias realizada con exito.");												
												//System.out.println(trasnferenciasACH);
												_listaTransferencias.add(trasnferenciasACH);
											}else {
												System.out.println("Error al realizar transferencia.");
											}
											
											break;//FIN DE TRANSFERENCIAS ACH
											
										case 2: //Transferencias entre Cuentas propias.
											
											System.out.println("TRANSFERENCIAS ENTRE CUENTAS PROPIAS");
											codtransferencia = gestionTECP.getCodigoTECP();
											System.out.println("Codigo: " + codtransferencia);
																					
											System.out.println("Seleccione el tipo de moneda: ");
											System.out.println("1. Lempiras.");
											System.out.println("2. Dolares");
											opcmoneda = scnum.nextByte();
											
											switch(opcmoneda) {
											case 1:
												tipomoneda = "Lempiras";
												break;
											case 2:
												tipomoneda = "Dolares";
												break;
												
												default:
													System.out.println("Opción no valida.\n");
													break;
											}
											
											System.out.print("Ingrese el número de cuenta a debitar: ");
											cuentaDebitar = scnum.nextInt();
													
											CuentaBancaria tipoCuenta5 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta5.get_numeroCuenta() == cuentaDebitar) {
												System.out.print("Ingrese el monto a transferir: ");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta5.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = scnum.nextInt();
											CuentaBancaria tipoCuenta6 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta6.get_numeroCuenta() == cuentaCreditar) {										
												tipoCuenta6.depositar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
																																																															
											System.out.print("Concepto de transferencia: ");
											concepto = sc.nextLine();
											System.out.print("Enviar confirmación a: ");
											enviarConfirmacion = sc.nextLine();
											
											
											TransferenciasCuentasPropias trasnPropias = new TransferenciasCuentasPropias(codtransferencia, tipomoneda,
													cuentaDebitar, cuentaCreditar, montoTransferir, concepto, enviarConfirmacion);
											
											if(gestionTECP.agregarTrasEntreCuentas(trasnPropias)) {
												System.out.println("Transferencias realizada con exito.");
												//System.out.println(trasnPropias);
												_listaTransferencias.add(trasnPropias);
											}else {
												System.out.println("Error al realizar transferencia.");
											}
											
											break;//fin de transferencias entre cuentas propias
											
										case 3: //Transferencias a terceros. (en el mismo banco)
											
											System.out.println("TRANSFERENCIAS A TERCEROS");
											codtransferencia = gestionTT.getCodigoTT();
											
											System.out.println("Seleccione el tipo de moneda:");
											System.out.println("1. Lempiras.");
											System.out.println("2. Dolares");
											opcmoneda = scnum.nextByte();
											
											switch(opcmoneda) {
											case 1:
												tipomoneda = "Lempiras";
												break;
											case 2:
												tipomoneda = "Dolares";
												break;
												
												default:
													System.out.println("Opción no valida.\n");
													break;
											}//fin selecccion tipo de moneda
											
											System.out.print("Ingrese el número de cuenta a debitar: ");
											cuentaDebitar = scnum.nextInt();
													
											CuentaBancaria tipoCuenta1 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta1.get_numeroCuenta() == cuentaDebitar) {
												System.out.print("Ingrese el monto a transferir: ");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta1.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = scnum.nextInt();
											CuentaBancaria tipoCuenta2 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta2.get_numeroCuenta() == cuentaCreditar) {										
												tipoCuenta2.depositar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											System.out.print("Concepto de transferencia: ");
											concepto = sc.nextLine();
											System.out.print("Enviar confirmación a: ");
											enviarConfirmacion = sc.nextLine();
											
											TransferenciasTerceros trasnTerceros = new TransferenciasTerceros(codtransferencia, tipomoneda,
													cuentaDebitar, cuentaCreditar, montoTransferir, concepto, enviarConfirmacion);
											
											if(gestionTT.agregarTT(trasnTerceros)) {
												System.out.println("Transferencias realizada con exito.\n");
												//System.out.println(trasnTerceros);
												_listaTransferencias.add(trasnTerceros);
											}else {
												System.out.println("Error al realizar transferencia.\n");
											}
											
											break;// fin de Transferencias a terceros. (en el mismo banco)
											
										case 4: //Transferencias internacionales.
											
											System.out.println("TRANSFERENCIAS INTERNACIONALES");
											codtransferencia = gestionTI.getCodigoTI();
											System.out.println("Codigo: " + codtransferencia);
											
											System.out.println("Seleccione el tipo de moneda:");
											System.out.println("1. Lempiras.");
											System.out.println("2. Dolares");
											opcmoneda = scnum.nextByte();
											
											switch(opcmoneda) {
											case 1:
												tipomoneda = "Lempiras";
												break;
											case 2:
												tipomoneda = "Dolares";
												break;
												
												default:
													System.out.println("Opción no valida.");
													break;
											}//Fin de seleccion de tipo de moneda
				
											System.out.print("Ingrese el número de cuenta a debitar: ");
											cuentaDebitar = scnum.nextInt();
													
											CuentaBancaria tipoCuenta3 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta3.get_numeroCuenta() == cuentaDebitar) {
												System.out.print("Ingrese el monto a transferir: ");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta3.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = scnum.nextInt();
											CuentaBancaria tipoCuenta4 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta4.get_numeroCuenta() == cuentaCreditar) {										
												tipoCuenta4.depositar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
																						
											System.out.println("Banco destino: ");
											bancodestino = sc.nextLine();
											System.out.print("Concepto de transferencia: ");
											concepto = sc.nextLine();
											System.out.print("Enviar confirmación a: ");
											enviarConfirmacion = sc.nextLine();
											
											TransferenciasInternacionales trasnferenciasInternacionales1 = new TransferenciasInternacionales(codtransferencia, tipomoneda,
													cuentaDebitar, cuentaCreditar, montoTransferir, bancodestino, concepto, enviarConfirmacion);
											
											if(gestionTI.agregarTI(trasnferenciasInternacionales1)) {
												System.out.println("Transferencias realizada con exito.\n");
												//System.out.println(trasnferenciasInternacionales1);
												_listaTransferencias.add(trasnferenciasInternacionales1);
											}else {
												System.out.println("Error al realizar transferencia.\n");
											}
											
											break;//fin de Transferencias internacionales.
											
											default:
												System.out.println("Opción no valida.\n");
												break;
										}
										
										break;
									case 5: //PAGO DE SERVICIOS
										
									
						
										break;
										
									case 6: //SALIR
										centinenlamenutrasn = false;
										break;
										default:
											System.out.println("Opcion no valida.");
											break;
									}//fin del swicth
									System.out.println("¿Desea realizar otra acción?\n1. SI\n2.NO");
									opcionTransferencias = scnum.nextByte();
									if(opcionTransferencias == 2) {
										centinenlamenutrasn = false;
									}
									
								}//FIN DEL WHILE DE TRASNFERENCIAS
								
							}//FIN DEL WHILE INICIO Y SESION
							
							break;
						case 2://SALIR MENU DE INICIO DE SESIÓN
							centinelaIniciosecion = false;
							
							break;
							
							default:
								System.out.println("OPCIÓN NO INVALIDA");
								break;
						}
					
					
					System.out.println("¿DESEA INICIAR SESIÓN DE NUEVO?\n1. SI\n2. NO");
					opcion3 = scnum.nextByte();
					if(opcion3 == 2) {
						centinelaIniciosecion = false;
					}
					
				}//FIN DE MENU INICIO SESION
				
				
				break;//FIN DE CODIGO PARA TRANSFERENCIAS
			
			case 3: //ELIMINAR TIPO DE CUENTA.
				
				System.out.println("ELIMINAR TIPO DE CUENTA");
				
				
				
				
				break;
			case 4: //ELIMINAR USUARIO.
				System.out.println("ELIMINAR USUARIO.");
				
				System.out.print("Ingrese su nombre de usuario: ");
				usuario = sc.nextLine();
				System.out.print("Ingrese su contraseña: ");
				constrasena = sc.nextLine();
				
				if(gestionUsuario.buscarNombreUsuario(usuario) && gestionUsuario.buscarcontrasena(constrasena)) {
					
					System.out.print("Ingrese su RTN: ");
					rtn = sc.nextLine();
					
					Usuario usuarioBuscado = gestionUsuario.buscarUsuario(rtn);
					
					if (usuarioBuscado == null) {
						System.out.println("Usuario no encontrado.\n");
					}else {
						
						if(gestionUsuario.eliminarUsuario(usuarioBuscado)){
							System.out.println("Usuario Eliminado correctamente.\n");
			
						}else {
							System.out.println("Error al eliminar usuario.\n");
						}
						
					}//FIN DE CODIGO DE CAMBIO DE USUARIO Y CONTRASEÑA
					
				}else {
					System.out.println("Usuario y contraseña incorrecto o Usuario no registrado.");
					break;
				}//FIN DE COMPROBACION DE USUARIO Y CONTRASEÑA
				
				break;// FIN PARA ELIMIMAR USUARIO
				
			case 5: //MODIFICAR USUARIO.
				
				System.out.println("MODIFICAR DATOS DE TITULAR");
				
				System.out.print("Ingrese su nombre de usuario: ");
				usuario = sc.nextLine();
				System.out.print("Ingrese su contraseña: ");
				constrasena = sc.nextLine();
				
				if(gestionUsuario.buscarNombreUsuario(usuario) && gestionUsuario.buscarcontrasena(constrasena)) {
					
					System.out.print("Ingrese su RTN: ");
					rtn = sc.nextLine();
					
					int posicionusuarioBuscado = gestionUsuario.buscarUsuarioPosicion(rtn);
					
					if (posicionusuarioBuscado == -1) {
						System.out.println("Usuario no encontrado.\n");
					}else {
						boolean centinelamodificacionUsuario = true;
						byte opcCentinela, opcModificacion;
						Usuario UsuarioEncontrado = gestionUsuario.getUsuarioPorPosicion(posicionusuarioBuscado);
						
						while(centinelamodificacionUsuario) {
							
							System.out.println("\nMENU MODIDICACION DE USUARIO");
							System.out.println("1. Modificar nombre y apellido.");
							System.out.println("2. Modificar fecha de nacimiento.");
							System.out.println("3. Modificar RTN.");
							System.out.println("4. Modificar telefono.");
							System.out.println("5. Modificar correo electronico.");
							System.out.println("6. Modificar nombre de usuario y contraseña.");
							System.out.println("7. Modificar referencia.");
							System.out.println("8. Salir.");
							opcModificacion = scnum.nextByte();
							
							switch(opcModificacion) {
							
							case 1: //Modificar nombre y apellido.
								//nombre, apellido, direccion, telefono, rtn, correoElectronico,
								System.out.println("Modificar nombre y apellido.");
								System.out.println("Su nombre completo actual es: " + UsuarioEncontrado.get_nombre() + " " +UsuarioEncontrado.get_apellido());
								System.out.println("Ingrese la modificación de sus nombres:");
								nombre = sc.nextLine();
								System.out.println("Ingrese la modificacion de sus apellidos:");
								apellido = sc.nextLine();
								
								Usuario UsuarioModificado1 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										nombre,apellido,UsuarioEncontrado.get_fechaNacimiento(), UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(),
										UsuarioEncontrado.get_rtn(), UsuarioEncontrado.get_correoelectronico(), UsuarioEncontrado.get_nombreUsuario(), 
										UsuarioEncontrado.get_contrasena() , UsuarioEncontrado.get_referencia());
							
								if(gestionUsuario.ModificarUsuario(UsuarioModificado1, posicionusuarioBuscado)) {
									System.out.println("\nNombres y apellidos modificados con exito.\n");
									System.out.println(UsuarioModificado1);
								}else {
									System.out.println("\nError al modificar nombres y apellidos.\n");
								}
								
								
								break; //FIN DE MOFICACION DE NOMBRES Y APELLIDOS
								
							case 2: //Modificar fecha de nacimiento.
								
								System.out.println("Modificar fecha de nacimiento");
								System.out.println("Su fecha de nacimiento actual es: " + UsuarioEncontrado.get_fechaNacimiento());
								System.out.print("Ingrese la modificación de su fecha de nacimiento (dd-MM-yyyy): ");
								fechaNacimiento = sc.nextLine();
								Date FechaNacimiento = AdminFechas.stringToDate(fechaNacimiento);
								
								Usuario UsuarioModificado2 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										UsuarioEncontrado.get_nombre(), UsuarioEncontrado.get_apellido(), FechaNacimiento, 
										UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(), UsuarioEncontrado.get_rtn(), 
										UsuarioEncontrado.get_correoelectronico(), UsuarioEncontrado.get_nombreUsuario(), 
										UsuarioEncontrado.get_contrasena() , UsuarioEncontrado.get_referencia());
							
								if(gestionUsuario.ModificarUsuario(UsuarioModificado2, posicionusuarioBuscado)) {
									System.out.println("\nFecha de nacimiento modificada con exito.\n");
									System.out.println(UsuarioModificado2);
								}else {
									System.out.println("\nError al modificar fecha de nacimiento.\n");
								}
								
								break;//FIN DE MODIFICACION DE FECHA DE NACIMIENTO
								
							case 3: //Modificar RTN.
								
								System.out.println("Modificar RTN");
								System.out.println("Su RTN actual es: " + UsuarioEncontrado.get_rtn());
								System.out.println("Ingrese la modificación de su fecha de nacimiento:");
								rtn = sc.nextLine();
								
								Usuario UsuarioModificado3 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										UsuarioEncontrado.get_nombre(), UsuarioEncontrado.get_apellido(), UsuarioEncontrado.get_fechaNacimiento(), 
										UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(), rtn, 
										UsuarioEncontrado.get_correoelectronico(), UsuarioEncontrado.get_nombreUsuario(), 
										UsuarioEncontrado.get_contrasena() , UsuarioEncontrado.get_referencia());
							
								if(gestionUsuario.ModificarUsuario(UsuarioModificado3, posicionusuarioBuscado)) {
									System.out.println("\nRTN modificada con exito.\n");
									System.out.println(UsuarioModificado3);
								}else {
									System.out.println("\nError al modificar RTN.\n");
								}
								
								break; // FIN DE MODIFICACION DE RTN
								
							case 4: //Modificar telefono.
								
								System.out.println("Modifcar telefono");
								System.out.println("Su número de telefono actual es: " + UsuarioEncontrado.get_telefono());
								System.out.println("Ingrese la modificación de su nuevo telefono:");
								telefono = sc.nextLine();
								
								Usuario UsuarioModificado4 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										UsuarioEncontrado.get_nombre(), UsuarioEncontrado.get_apellido(), UsuarioEncontrado.get_fechaNacimiento(), 
										UsuarioEncontrado.get_direccion(),telefono, UsuarioEncontrado.get_rtn(), 
										UsuarioEncontrado.get_correoelectronico(), UsuarioEncontrado.get_nombreUsuario(), 
										UsuarioEncontrado.get_contrasena() , UsuarioEncontrado.get_referencia());
							
								if(gestionUsuario.ModificarUsuario(UsuarioModificado4, posicionusuarioBuscado)) {
									System.out.println("\ntelefono modificada con exito.\n");
									System.out.println(UsuarioModificado4);
								}else {
									System.out.println("\nError al modificar telefono.\n");
								}
								
								break; //FIN DE MODIFICACION DE TELEFONO 
								
							case 5: //Modificar correo electronico."
								
								System.out.println("Modificar correo electronico");
								System.out.println("Su correo electronico actual es: " + UsuarioEncontrado.get_correoelectronico());
								System.out.println("Ingrese la modificación de su correo electronico:");
								correoElectronico = sc.nextLine();
								
								Usuario UsuarioModificado5 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										UsuarioEncontrado.get_nombre(), UsuarioEncontrado.get_apellido(), UsuarioEncontrado.get_fechaNacimiento(), 
										UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(), UsuarioEncontrado.get_rtn(), 
										correoElectronico, UsuarioEncontrado.get_nombreUsuario(), 
										UsuarioEncontrado.get_contrasena() , UsuarioEncontrado.get_referencia());
							
								if(gestionUsuario.ModificarUsuario(UsuarioModificado5, posicionusuarioBuscado)) {
									System.out.println("\nCorreo electronico modificada con exito.\n");
									System.out.println(UsuarioModificado5);
								}else {
									System.out.println("\nError al modificar correo electronico.\n");
								}
								
								break;
								
							case 6: // Modificar nombre de usuario y contraseña.
								
								System.out.println("Modificar Nombre de usuario y contraseña");
								System.out.println("Su nombre de usuario actual es: " + UsuarioEncontrado.get_nombreUsuario());
								System.out.println("Su contraseña actual es: " + UsuarioEncontrado.get_contrasena());
								
								//NOMBRE DE USUARIO Y CONSTRASEÑA
								boolean centinelaUsuario = true, centinelaContraseña = true;
								
								//CREAR NOMBRE DE USUARIO
								while(centinelaUsuario) {
									System.out.print("NUEVO NOMBRE DE USUARIO: ");
									usuario = sc.nextLine();
									
									System.out.println("CONFIRMAR NUEVO NOMBRE DE USUARIO: ");
									usuarioConfir = sc.nextLine();
									
									if(gestionUsuario.confirmar(usuario, usuarioConfir)) {
										System.out.println("Nuevo nombre de usuario creado correctamente.\n");
										centinelaUsuario = false;
									}else {
										System.out.println("Los nombres de usuario no coinciden.");
									}
								}//FIN DE CODIGO PARA CREAR NOMBRE DE USUARIO
								
								//CREAR CONTRASEÑA
								System.out.println("Cree nueva contraseña. \n");
								while(centinelaContraseña) {
									System.out.println("Nueva Contraseña: ");
									constrasena = sc.nextLine();
									
									System.out.println("Confirmar nueva contraseña: ");
									constrasenaconfirm = sc.nextLine();
									
									if(gestionUsuario.confirmar(constrasena, constrasenaconfirm)) {
										System.out.println("Nueva contraseña creada con exito");
										centinelaContraseña = false;
									}else {
										System.out.println("Las constraseñas no coinciden.");
									}
								}//FIN DE CODIGO PARA CREAR CONTRASEÑA
								
								Usuario UsuarioModificado6 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										UsuarioEncontrado.get_nombre(),UsuarioEncontrado.get_apellido(),UsuarioEncontrado.get_fechaNacimiento(),
										UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(),UsuarioEncontrado.get_rtn(),
										UsuarioEncontrado.get_correoelectronico(), usuario, constrasena, UsuarioEncontrado.get_referencia());
							
							if(gestionUsuario.ModificarUsuario(UsuarioModificado6, posicionusuarioBuscado)) {
								System.out.println("\nNombre de usuario y contraseña modificado con exito.\n");
								System.out.println(UsuarioModificado6);
							}else {
								System.out.println("\nError al modificar nombre de usuario y contraseña.\n");
							}
								
								break;// FIN DE MODIFICAR USUARIO Y CONTRASEÑA
								
							case 7: // Modificar referencia.
								
								System.out.println("Modificar referencia");
								System.out.println("Su referencia actual es: " + UsuarioEncontrado.get_referencia());
								
								System.out.print("Ingrese nuevos nombres: ");
								nombreReferencia = sc.nextLine();
								System.out.print("Ingrese nuevos apellidos: ");
								apellidoreferencia = sc.nextLine();
								System.out.print("Ingrese nueva fecha de nacimiento (dd-MM-yyyy): ");
								fechaNacimiento = sc.nextLine();
								Date FechaNacimientoReferencia = AdminFechas.stringToDate(fechaNacimiento);
								System.out.print("Ingrese nueva dirección: ");
								direccionreferencia = sc.nextLine();
								System.out.print("Ingrese nuevo telefono: ");
								telefonoreferencia = sc.nextLine();
								System.out.print("Ingrese nuevo RTN: ");
								rtnreferencia = sc.nextLine();
								System.out.print("Ingrese nuevo correo electronico: ");
								correorefencia = sc.nextLine();
								
								int posicionReferencia = gestionRefencia.buscarReferenciaPosicion(UsuarioEncontrado.get_referencia().get_rtn());
								
								Referencia referenciaModificar = new Referencia(UsuarioEncontrado.get_referencia().get_codigoReferencia(), nombreReferencia, apellidoreferencia,
										FechaNacimientoReferencia, direccionreferencia, telefonoreferencia, rtnreferencia, correorefencia);
								
								Usuario UsuarioModificado7 = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
										UsuarioEncontrado.get_nombre(),UsuarioEncontrado.get_apellido(),UsuarioEncontrado.get_fechaNacimiento(),
										UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(),UsuarioEncontrado.get_rtn(),
										UsuarioEncontrado.get_correoelectronico(), UsuarioEncontrado.get_nombreUsuario(), UsuarioEncontrado.get_contrasena(), referenciaModificar);
								
								if(gestionRefencia.modificarReferencia(referenciaModificar, posicionReferencia) && gestionUsuario.ModificarUsuario(UsuarioModificado7, posicionusuarioBuscado)){
									System.out.println("\nReferencia modificada con exito.\n");
									System.out.println(UsuarioModificado7);
									
								}else {
									System.out.println("Error al modifcar referencia.");
								}
								
								break;//Fin de modificacion de referencia del usuario.
								
							case 8: // SALIR
								
								break;//Salir
								
								default:
									System.out.println("Opción no valida:\n");
									break;
									
							}//FIN DE IMPLEMENTACION DE MODIFICACION DE USUARIO
							
							System.out.println("¿Desea realizar otra modifcacion al usuario?\n1. SI\n2. NO");
							opcCentinela = scnum.nextByte();
							if(opcCentinela == 2) {
								centinelamodificacionUsuario = false;
							}
							
						} //fin del while del menu de modificacion de usuario
						
					} // Fin de codigo para comprobar usuario
					
				}else {
					System.out.println("Usuario y contraseña incorrecto o Usuario no registrado.");
					break;
				}//FIN DE COMPROBACION DE USUARIO Y CONTRASEÑA
				
				break; //FIN DE MODIFICACION DE USUARIO
				
			case 6: // INFORMACION PERSONAL
				
				System.out.println("INFORMACION PERSONAL");
				
				System.out.print("Ingrese su nombre de usuario: ");
				usuario = sc.nextLine();
				System.out.print("Ingrese su contraseña: ");
				constrasena = sc.nextLine();
				
				if(gestionUsuario.buscarNombreUsuario(usuario) && gestionUsuario.buscarcontrasena(constrasena)) {
					
					System.out.print("Ingrese su RTN: ");
					rtn = sc.nextLine();
					
					Usuario usuarioBuscado = gestionUsuario.buscarUsuario(rtn);
					//CuentaBancaria tipoCuentaBuscada = gestionCuentaBancaria.bucarTipoCuenta(rtn);
					
					if (usuarioBuscado == null) {
						System.out.println("Usuario no encontrado.\n");
					}else {
						
						boolean centinelamenuinfo = true;
						Byte opcmenupersonal, opcCentinela2;
						while(centinelamenuinfo) {
							
							System.out.println("\nMENU DE INFORMACION PERSONAL");
							System.out.println("1. DATOS PERSONALES");//YA
							System.out.println("2. INFORMACION DE CUENTAS BANCARIAS");//YA
							System.out.println("3. INFORMACION REFERENCIA");//YA
							System.out.println("4. INFORMACION BENEFICIARIO");
							System.out.println("5. INFORMACION DE TRANSFERENCIAS");
							System.out.println("6. INFORMACION DE PAGOS");
							System.out.println("7. SALIR");
							opcmenupersonal = scnum.nextByte();
							
							switch(opcmenupersonal) {
							case 1: //  DATOS PERSONALES
								
								System.out.println("Datos personales:");
								
								for(Persona personaactual: _listaPersona) {
									if (personaactual instanceof Persona) {
										System.out.println(personaactual.getClass().getName());
										if(personaactual.equals(usuarioBuscado)) {
											System.out.println(personaactual.toString());
										}										
									}
								}
							
								
								break;// fin de DATOS PERSONALES
								
							case 2: // INFORMACION DE CUENTAS BANCARIAS
								byte opcinfobancaria;
								
								System.out.println("\nInformación de cuentas bancarias");
								System.out.println("1. CUENTA DE AHORRO.");//ya
								System.out.println("2. CUENTA DE CHEQUES.");//ya
								System.out.println("3. CUENTA CORRIENTE PERSONAL.");//ya
								System.out.println("4. CUENTA DE NOMINA.");//ya
								System.out.println("5. SALIR");
								opcinfobancaria = scnum.nextByte();
							
								
								switch(opcinfobancaria) {
								
								case 1: //CUENTA DE AHORRO. 
									CuentaBancaria tipoCuentaBuscada = gestionCuentaBancaria.bucarTipoCuenta(rtn, "CUENTA DE AHORROS");
									System.out.println("INFORMACION DE CUENTA DE AHORRO");
									
									for(CuentaBancaria CuentaActual: _listaCuentasBancarias) {
										if(CuentaActual instanceof CuentaAhorro) {
											
											System.out.println(CuentaActual.getClass().getName());
											if(CuentaActual.equals(tipoCuentaBuscada)) {
												System.out.println(CuentaActual.toString());
											}											
										}
									}
									
									break;//FIN CUENTA DE AHORRO.
									
								case 2: //CUENTA DE CHEQUES.
									CuentaBancaria tipoCuentaBuscada1 = gestionCuentaBancaria.bucarTipoCuenta(rtn, "CUENTA DE CHEQUES");
									
									for(CuentaBancaria CuentaActual: _listaCuentasBancarias) {
										if(CuentaActual instanceof CuentaCheques) {
											
											System.out.println(CuentaActual.getClass().getName());
											String _infoCuentaBancaria = tipoCuentaBuscada1.toString();
																			
											System.out.println(_infoCuentaBancaria);
											break;
										}
									}
									
									break;//FIN CUENTA DE CHEQUES.
									
								case 3: //CUENTA CORRIENTE PERSONAL
									CuentaBancaria tipoCuentaBuscada2 = gestionCuentaBancaria.bucarTipoCuenta(rtn, "CUENTA CORRIENTE PERSONAL");
									for(CuentaBancaria CuentaActual: _listaCuentasBancarias) {
										if(CuentaActual instanceof CuentaCorrientePersonal) {
											
											System.out.println(CuentaActual.getClass().getName());
											String _infoCuentaBancaria = tipoCuentaBuscada2.toString();
											
											System.out.println(_infoCuentaBancaria);
											break;
										}
									}
									
									break; //FIN CUENTA CORRIENTE PERSONAL
									
								case 4: //CUENTA DE NOMINA
									CuentaBancaria tipoCuentaBuscada3 = gestionCuentaBancaria.bucarTipoCuenta(rtn, "CUENTA DE NOMINA");
									for(CuentaBancaria CuentaActual: _listaCuentasBancarias) {
										
										if(CuentaActual instanceof CuentaNomina) {
											System.out.println(CuentaActual.getClass().getName());
											String _infoCuentaBancaria = tipoCuentaBuscada3.toString();
											
											System.out.println(_infoCuentaBancaria);
											break;
										}
									}
									
									break;//FIN CUENTA DE NOMINA
									
								case 5: //SALIR
									break;//FIN DE SALIR
									default:
										System.out.println("Opción no valida.");
										break;
								}
																
								break;//FIN DE INFORMACION DE CUENTAS BANCARIAS
								
							case 3: //INFORMACION DE REFERENCIA
								
								System.out.println("Información de referencia.");
								
								for(Persona personaactual: _listaPersona) {
									if (personaactual instanceof Referencia) {
										System.out.println(personaactual.getClass().getName());
										String _infousuario = usuarioBuscado.get_referencia().toString();
										System.out.println(_infousuario);
									}
								}
								
								break;//FIN DE INFORMACION DE REFERENCIA
								
							case 4:// INFORMACION DE BENEFICIARIO
								
								System.out.println("INFORMACION DE BENEFICIARIO");
								
								System.out.print("Ingrese RTN Beneficiario: ");
								rtn = sc.nextLine();
								
								SeguroMedico SeguroBuscado = gestionSeguroMedico.buscarSeguroMedico(rtn);
								
								for(Persona personaactual: _listaPersona) {
									if (personaactual instanceof Beneficiario) {
										
										String _infousuario = SeguroBuscado.get_beneficiario().toString();
										System.out.println(_infousuario);
									}
								}
								
								
								break; // FIN DE INFORMACION DE BENEFICIARIO
								
							case 5: //INFORMACION DE TRANSFERENCIAS
								byte opcinfoTransferencias;
								
								System.out.println("MENU INFORMACION DE TRANSFERENCIAS");
								System.out.println("1. INFORMACION TRANSFERENCIAS ACH");
								System.out.println("2. INFORMACION TRANSFERENCIAS ENTRE CUENTAS PROPIAS");
								System.out.println("3. INFORMACION TRANSFERENCIAS A TERCEROS");
								System.out.println("4. INFORMACION TRANSFERENCIAS INTERNACIONALES");
								System.out.println("5. SALIR");
								opcinfoTransferencias = scnum.nextByte();
								
								switch(opcinfoTransferencias) {
								
								case 1: //INFORMACION TRANSFERENCIAS ACH
									for(Transferencias transferenciaActual: _listaTransferencias) {
										if(transferenciaActual instanceof TransferenciasACH) {
											System.out.println(transferenciaActual.getClass().getName());
											System.out.println(transferenciaActual.toString());
										}
										
									}
									
									break; //FIN INFORMACION TRANSFERENCIAS ACH
									
								case 2: //INFORMACION TRANSFERENCIAS ENTRE CUENTAS PROPIAS
									
									for(Transferencias transferenciaActual: _listaTransferencias) {
										if(transferenciaActual instanceof TransferenciasCuentasPropias) {
											System.out.println(transferenciaActual.getClass().getName());
											//transferenciaActual.equals()
										}
										
									}
									
									break; //FIN INFORMACION TRANSFERENCIAS ENTRE CUENTAS PROPIAS
									
								case 3: //INFORMACION TRANSFERENCIAS A TERCEROS
									
									for(Transferencias transferenciaActual: _listaTransferencias) {
										if(transferenciaActual instanceof TransferenciasTerceros) {
											System.out.println(transferenciaActual.getClass().getName());
											System.out.println(transferenciaActual.toString());
										}
										
									}
									
									
									break; //FIN INFORMACION TRANSFERENCIAS A TERCEROS
									
								case 4: //INFORMACION TRANSFERENCIAS INTERNACIONALES
									
									for(Transferencias transferenciaActual: _listaTransferencias) {
										if(transferenciaActual instanceof TransferenciasInternacionales) {
											System.out.println(transferenciaActual.getClass().getName());
											System.out.println(transferenciaActual.toString());
										}
										
									}
									
									
									break;//FIN INFORMACION TRANSFERENCIAS INTERNACIONALES
									
								case 5: //SALIR
									break;
									
									default:
										break;
								
								} // FIN DE INFORMACION DE TRANSFERENCIAS
								
								break; //FIN INFORMACION DE TRANSFERENCIAS
								
							case 6://INFORMACION DE PAGOS
								byte opcinfopagos;
								
								System.out.println("MENU INFORMACION DE PAGOS");						
								System.out.println("1. INFORMACION DE PAGOS DE TAJETAS DE CREDITO");
								System.out.println("2. INFORMACION DE PAGOS PRESTAMOS");
								System.out.println("3. INFORMACION DE PAGOS DE SERVICIOS");
								System.out.println("4. INFORMACION DE PAGOS DE SEGUROS");
								System.out.println("5. SALIR");
								opcinfopagos = scnum.nextByte();
								
								switch(opcinfopagos) {
								
									case 1: //INFORMACION DE PAGOS DE TAJETAS DE CREDITO
									
										System.out.println("INFORMACION DE PAGOS DE TAJETAS DE CREDITO");
									
										for(Pagos PagosActual: _listaPagos) {
											if(PagosActual instanceof TarjetaCredito) {
												System.out.println(PagosActual.getClass().getName());
												System.out.println(PagosActual.toString());
											}
										}
									
									
										break; //FIN INFORMACION DE PAGOS DE TAJETAS DE CREDITO
									
									case 2: //INFORMACION DE PAGOS PRESTAMOS
									
										System.out.println("INFORMACION DE PAGOS PRESTAMOS");
									
									
									
										for(Pagos PagosActual: _listaPagos) {
											if(PagosActual instanceof Prestamos) {
												System.out.println(PagosActual.getClass().getName());
												System.out.println(PagosActual.toString());
											}
										}
									
										break; //FIN INFORMACION DE PAGOS PRESTAMOS
									
									case 3: //INFORMACION DE PAGOS DE SERVICIOS
										System.out.println("INFORMACION DE PAGOS DE SERVICIOS");
									
										for(Pagos PagosActual: _listaPagos) {
											if(PagosActual instanceof Servicios) {
												System.out.println(PagosActual.getClass().getName());
												System.out.println(PagosActual.toString());
											}
										}
									
										break; //FIN INFORMACION DE PAGOS DE SERVICIOS
									
									case 4: //INFORMACION DE PAGOS DE SEGUROS
										byte opcinfoSeguros;
									
										System.out.println("INFORMACION DE PAGOS DE SEGUROS");
										System.out.println("1. SEGURO DE MEDICO");
										System.out.println("2. SEGURO DE AUTO");
									
										opcinfoSeguros = scnum.nextByte();
									
										switch(opcinfoSeguros) {
									
											case 1:
												System.out.println("SEGURO DE MEDICO");
										
												for(Pagos PagosActual: _listaPagos) {
													if(PagosActual instanceof SeguroMedico) {
														System.out.println(PagosActual.getClass().getName());
														System.out.println(PagosActual.toString());
													}
												}
												break;
										
											case 2:
												System.out.println("2. SEGURO DE AUTO");
										
												for(Pagos PagosActual: _listaPagos) {
													if(PagosActual instanceof SeguroAuto) {
														System.out.println(PagosActual.getClass().getName());
														System.out.println(PagosActual.toString());
													}
												}
										
												break;
										}
									
										break; //FIN INFORMACION DE PAGOS DE SEGUROS
									
									case 5: //SALIR
									
										break;
									
										default:
											System.out.println("Opción no valida.");
											break;
								}
								
								break; //FIN DE INFORMACION DE PAGOS
								
							case 7: //SALIR
								
								break;
								
								default:
									System.out.println("Opción no valida.");
									break;
							} //FIN MENU INFORMACION DE PAGOS
														
							System.out.println("¿Desea obtener otro dato personal?\n1. SI\n2. N0");
							opcCentinela2 = scnum.nextByte();
							if(opcCentinela2 == 2) {
								centinelamenuinfo = false;
							}
						}
						
					}
					
				}else {
					System.out.println("Usuario y contraseña incorrecto o Usuario no registrado.");
					break;
				}

				break; //FIN DE INFORMACION PERSONAL
					
			case 7: //SALIR
				centinelaPrincipal = false;
				break;
				default: 
					System.out.println("OPCIÓN NO VALIDA.");
					break;
			}
		}
		sc.close();
		scnum.close();
		/*-----------------------------------------------------------------------------------------------------------*/
		/*--------------------------------------------------FIN-----------------------------------------------------*/
		/*---------------------------------------------------------------------------------------------------------*/
	}
}