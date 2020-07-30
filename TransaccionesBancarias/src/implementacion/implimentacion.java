package implementacion;

import java.util.Scanner;

import clases.*;
import gestionClases.*;
import utileria.AdminFechas;
import java.util.Date;

public class implimentacion {

	public static void main(String[] args) {
		
		//instancia de Scanner
		Scanner sc = new Scanner(System.in);
		Scanner scnum = new Scanner(System.in);
		
		//variables
		String nombre, apellido, direccion, telefono, rtn, correoElectronico;
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
		
		
		//INSTANCIA PARA REALIZAR IMPLEMETACION
		Referencia ref1 = new Referencia(gestionRefencia.getCodigoReferencia(),"Ana","Fuentes", AdminFechas.getFechaActual(),"TGU","98123412","1702200500123","AA@");
		Usuario titular = new Usuario(gestionUsuario.getCodigoUsuario(),AdminFechas.getFechaActual(),"Alex","Fuentes",
				AdminFechas.stringToDate("25-11-1999"),"TGU","98123412", "1702199900192","aaf@unah.hn","AAFM","1234", ref1);
		
		CuentaAhorro CuentaAhorros = new CuentaAhorro(titular, AdminFechas.getFechaActual(),"CUENTA DE AHORROS", "202012345", 20000 + gestionCuentaAhorro.InteresRemunerado(20000),gestionCuentaAhorro.InteresRemunerado(20000));
		CuentaCheques Cuentacheques = new CuentaCheques(titular, AdminFechas.getFechaActual(),"CUENTA DE Cheques", "202067890", 1000000 + gestionCuentaCheques.InteresRemunerados(1000000), gestionCuentaCheques.InteresRemunerados(1000000));
		
		gestionCuentaBancaria.AgregarTipoCuenta(CuentaAhorros);		
		gestionCuentaBancaria.AgregarTipoCuenta(Cuentacheques);
		gestionCuentaAhorro.AgregarCuentaAhorro(CuentaAhorros);
		gestionCuentaCheques.AgregarCuentaCheques(Cuentacheques);
		gestionUsuario.AgregarUsuario(titular);
		/*-----------------------------------------------------------------------------------------------------------*/
		/*-------------------------------------------------INICIO---------------------------------------------------*/
		/*---------------------------------------------------------------------------------------------------------*/
		
		while(centinelaPrincipal) {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1. REGISTRARSE.");
			System.out.println("2. INICIAR SESIÓN.");
			System.out.println("3. CAMBIAR NOMBRE DE USUARIO O CONTRASEÑA.");
			System.out.println("4. ELIMINAR TIPO DE CUENTA.");
			System.out.println("5. ELIMINAR USUARIO.");
			System.out.println("6. MODIFICAR USUARIO.");
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
							boolean centinelaUsuario = true, centinelaContraseña = true;
							String usuario = "", usuarioConfir = "",constrasena = "", constrasenaconfirm = "";
							
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
							while(centinelaContraseña) {
								System.out.print("Contraseña: ");
								constrasena = sc.nextLine();
								
								System.out.print("Confirmar contraseña: ");
								constrasenaconfirm = sc.nextLine();
								
								if(gestionUsuario.confirmar(constrasena, constrasenaconfirm)) {
									System.out.println("Contraseña creada con exito\n");
									centinelaContraseña = false;
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
							
							if(gestionUsuario.AgregarUsuario(Titular1)) {
								System.out.println("DATOS DEL USUARIO AGREGADO CORRECTAMENTE.\n");
							} else {
								System.out.println("EL USUARIO YA EXISTE.\n");
							}
							
							break;
						case 2: //INGRESE REFERENCIA.
							
							//boolean ceninelaRefencia = true;
							//byte opcionReferencia;
							
							//while(ceninelaRefencia){
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
								
								if(gestionRefencia.AgregarReferencia(referencia1)) {
									Titular1.set_referencia(referencia1);
									System.out.println("REFERENCIA AGREGADA CON EXITO.\n");
									//System.out.println(referencia1);
								}else {
									System.out.println("ERROR AL AGREGAR REFERENCIA.\n");
								}
								
								/*
								System.out.println("Desea agregar otra referencia. 1. SI 2. NO");
								opcionReferencia = scnum.nextByte();
								if(opcionReferencia == 2) {
									ceninelaRefencia = false;
								}
							}*/
							
							break;
						case 3: //CREE UN TIPO DE CUENTA BANCARIA.
							boolean centinelatipocuenta = true;
							byte opciontipoCuenta, opcion1;
							double montoInicial = 0, interesRemunerado; 
							String NumCuenta;
							
							//CuentaBancaria tipoCuenta1 = new CuentaBancaria();
							
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
												interesRemunerado = gestionCuentaAhorro.InteresRemunerado(montoInicial);
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaAhorro cuentaAhorro1 = new CuentaAhorro(Titular1, AdminFechas.getFechaActual(),"CUENTA DE AHORRO", NumCuenta,
														montoInicial + interesRemunerado, interesRemunerado);
												
												if(gestionCuentaAhorro.AgregarCuentaAhorro(cuentaAhorro1)) {
													//if(Titular1.AgregarCuentaBancaria(cuentaAhorro1)) {
														System.out.println("CUENTA DE AHORRO CREADA EXITOSAMENTE.\n");
														System.out.println(cuentaAhorro1);
													//}
													}else {
														System.out.println("ERROR AL CREAR CUENTA DE AHORRO.\n");
														break;
													}
												
												} else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE AHORRO.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											break;
										case 2: //CUENTA DE CHEQUES
											
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1 ) {
												
												System.out.println("APERTURA DE CUENTA DE CHEQUES\n");
												System.out.print("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												interesRemunerado = gestionCuentaCheques.InteresRemunerados(montoInicial);
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaCheques cuentachques1 = new CuentaCheques(Titular1, AdminFechas.getFechaActual(),"CUENTA DE CHEQUES", 
														NumCuenta, montoInicial + interesRemunerado, interesRemunerado);
												
												if(gestionCuentaCheques.AgregarCuentaCheques(cuentachques1)) {
													//if(usuario1.AgregarCuentaBancaria(cuentachques1)) {
														System.out.println("CUENTA DE CHEQUES CREADA EXITOSAMENTE.\n");
														System.out.println(cuentachques1);
													//}
													}else {
														System.out.println("ERROR AL CREAR CUENTA DE CHEQUES.\n");
														break;
													}
					
												} else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE CHEQUES.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											break;
										case 3: // CUENTA CORRIENTE PERSONAL
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1) {
												
												System.out.println("APERTURA DE CUENTA CORRIENTE PERSONAL\n");
												System.out.print("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaCorrientePersonal cuentaCorrientepers1 = new CuentaCorrientePersonal(Titular1, AdminFechas.getFechaActual(),
														"CUENTA CORRIENTE PERSONALA", NumCuenta, montoInicial);
												
												if(gestionCuenCorrienteper.AgregarCuentaCorrientePersonal(cuentaCorrientepers1)) {
													//if(usuario1.AgregarCuentaBancaria(cuentaCorrientepers1)) {
														System.out.println("CUENTA CORRIENTE PERSONAL CREADA EXITOSAMENTE.\n");
														System.out.println(cuentaCorrientepers1);
													//}
													}else {
														System.out.println("ERROR AL CREAR CUENTA CORRIENTE PERSONAL.\n");
														break;
													}	
												
												} else {
													System.out.println("USUARIO NO ENCONTRADO PARA ASIGNARLE CUENTA DE CHEQUES.");
													System.out.println("DEBE INGRESAR SUS DATOS PERSONALES ANTES DE CREAR UNA CUENTA BANCARIA.");
												}
											
											
											break;
										case 4: //CUENTA DE NOMINA
											String empresa;
											if(gestionUsuario.buscarUsuarioPosicion(Titular1.get_rtn()) != -1) {
												
												System.out.println("APERTURA DE CUENTA DE NOMINA\n");
												System.out.print("Ingrese la empresa depositante:");
												empresa = sc.nextLine();
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaNomina cuentaNomina1 = new CuentaNomina(Titular1, AdminFechas.getFechaActual(), "CUENTA DE NOMINA", 
														NumCuenta, 0, empresa);
												
												if(gestionCuentaNomina.AgregarCuentaNomina(cuentaNomina1)) {
													//if(usuario1.AgregarCuentaBancaria(cuentaNomina1)){
														System.out.println("CUENTA DE NOMINA CREADA EXITOSAMENTE.\n");
														System.out.println(cuentaNomina1);
													//}
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
				
				//aqui agregar codigo de detalle usuario
				
				/*
				if(gestionUsuario.AgregarUsuario(usuario1)) {
					System.out.println("ERROR AL REGISTRAR USUARIO\n");
				}else {
					System.out.println("USUARIO REGISTRADO CORRECTAMENTE.\n");
				}*/
				
				//gestionUsuario.imprimirTodos();
				System.out.println(Titular1);
				
				
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
							String usuario, contrasena;
							
							
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
								String numCuenta;
								byte opcion;
								
								while(centinenlamenutrasn) {
									System.out.println("MENU DE OPERACIONES BANCARIAS");
									System.out.println("1. Depositar.");
									System.out.println("2. Retirar.");
									System.out.println("3. Consultar saldo.");
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
											numCuenta = sc.nextLine();
											
											CuentaAhorro CtaAhorroBuscada = gestionCuentaAhorro.BuscarCuentaAhorro(numCuenta);
											
											if(CtaAhorroBuscada != null) {
												System.out.print("Ingrese el monto a depositar:");
												monto = scnum.nextDouble();
												interesRemunerado = gestionCuentaAhorro.InteresRemunerado(monto);
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
											numCuenta = sc.nextLine();
											
											CuentaCheques CtaChequesBuscada = gestionCuentaCheques.BuscarCuentaCheques(numCuenta);
											
											if(CtaChequesBuscada != null) {
												System.out.print("Ingrese el monto a depositar:");
												monto = scnum.nextDouble();
												interesRemunerado = gestionCuentaCheques.InteresRemunerados(monto);
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
											numCuenta = sc.nextLine();
											
											CuentaCorrientePersonal CtsCorrientePersonalBuscada = gestionCuenCorrienteper.BuscarCuentaCorrientePersonal(numCuenta);
											
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
											numCuenta = sc.nextLine();
											
											CuentaAhorro CtaAhorroBuscada = gestionCuentaAhorro.BuscarCuentaAhorro(numCuenta);
											
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
											numCuenta = sc.nextLine();
											
											CuentaCheques CtaChequesBuscada = gestionCuentaCheques.BuscarCuentaCheques(numCuenta);
											
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
											numCuenta = sc.nextLine();
											
											CuentaCorrientePersonal CtsCorrientePersonalBuscada = gestionCuenCorrienteper.BuscarCuentaCorrientePersonal(numCuenta);
											
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
											numCuenta = sc.nextLine();
											
											CuentaNomina CtaNominaBuscada = gestionCuentaNomina.BuscarCuentaNomina(numCuenta);
											
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
											numCuenta = sc.nextLine();
											
											CuentaAhorro CtaAhorroBuscada = gestionCuentaAhorro.BuscarCuentaAhorro(numCuenta);
											
											if(CtaAhorroBuscada != null) {
												System.out.println("Su saldo es: " + CtaAhorroBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
										case 2: //consulta de saldo de cuenta de cheques
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = sc.nextLine();
											
											CuentaCheques CtaChequesBuscada = gestionCuentaCheques.BuscarCuentaCheques(numCuenta);
											
											if(CtaChequesBuscada != null) {
												System.out.println("Su saldo es: " + CtaChequesBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
										case 3://Consulta de saldo de cuenta corriente personal
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = sc.nextLine();
											
											CuentaCorrientePersonal CtsCorrientePersonalBuscada = gestionCuenCorrienteper.BuscarCuentaCorrientePersonal(numCuenta);
											
											if(CtsCorrientePersonalBuscada != null) {
												System.out.print("Su saldo es: " + CtsCorrientePersonalBuscada.consultarSaldo());
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											break;
										case 4://Consulta de saldo de cuenta de nomina
											
											System.out.print("Ingrese Su numero de cuenta: ");
											numCuenta = sc.nextLine();
											
											CuentaNomina CtaNominaBuscada = gestionCuentaNomina.BuscarCuentaNomina(numCuenta);
											
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
										
										String codtransferencia, tipomoneda = "", cuentaDebitar = "", cuentaCreditar, concepto,
										enviarConfirmacion, bancodestino;
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
											cuentaCreditar = sc.nextLine();
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
											cuentaDebitar = sc.nextLine();
													
											CuentaBancaria tipoCuenta7 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta7.get_numeroCuenta().equals(cuentaDebitar)) {
												System.out.println("Ingrese el monto a transferir.");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta7.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											/*
											System.out.print("Ingrese el numero de cuenta a acreditar.");
											cuentaCreditar = sc.nextLine();
											CuentaBancaria tipoCuenta6 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta6.get_numeroCuenta().equals(cuentaCreditar)) {										
												tipoCuenta6.depositar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											*/
											
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
												System.out.println(trasnferenciasACH);
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
											cuentaDebitar = sc.nextLine();
													
											CuentaBancaria tipoCuenta5 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta5.get_numeroCuenta().equals(cuentaDebitar)) {
												System.out.print("Ingrese el monto a transferir: ");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta5.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = sc.nextLine();
											CuentaBancaria tipoCuenta6 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta6.get_numeroCuenta().equals(cuentaCreditar)) {										
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
												System.out.println(trasnPropias);
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
											cuentaDebitar = sc.nextLine();
													
											CuentaBancaria tipoCuenta1 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta1.get_numeroCuenta().equals(cuentaDebitar)) {
												System.out.print("Ingrese el monto a transferir: ");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta1.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.");
											}
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = sc.nextLine();
											CuentaBancaria tipoCuenta2 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta2.get_numeroCuenta().equals(cuentaCreditar)) {										
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
												System.out.println(trasnTerceros);
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
											cuentaDebitar = sc.nextLine();
													
											CuentaBancaria tipoCuenta3 = gestionCuentaBancaria.bucarTipoCuenta(cuentaDebitar);
											
											if(tipoCuenta3.get_numeroCuenta().equals(cuentaDebitar)) {
												System.out.print("Ingrese el monto a transferir: ");
												montoTransferir = scnum.nextDouble();
												
												tipoCuenta3.retirar(montoTransferir);
											}else {
												System.out.println("Cuenta no encontrada.\n");
											}
											
											System.out.print("Ingrese el numero de cuenta a acreditar: ");
											cuentaCreditar = sc.nextLine();
											CuentaBancaria tipoCuenta4 = gestionCuentaBancaria.bucarTipoCuenta(cuentaCreditar);
											
											if(tipoCuenta4.get_numeroCuenta().equals(cuentaCreditar)) {										
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
												System.out.println(trasnferenciasInternacionales1);
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
										
										/*
										 * 
										 * 	FALTA ESTA MADRE
										 * 
										 */
										
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
				
				
				break;
			case 3: //CAMBIAR NOMBRE DE USUARIO O CONTRASEÑA
				
				byte opcionmenuCC;
				String rtn1, nomUsuario, contrasena1; 
				
				System.out.println("MENU CAMBIO DE USUARIO Y CONTRASEÑA");
					System.out.println("1. INGRESAR USUARIO Y CONSTRASEÑA.");
					System.out.println("2. SALIR.");
					opcionmenuCC = scnum.nextByte();
						switch(opcionmenuCC) {
						case 1: //INGRESAR USUARIO Y CONSTRASEÑA.
							
								System.out.print("INGRESE SU NOMBRE DE USUARIO: ");
								nomUsuario = sc.nextLine();
								System.out.print("INGRESE SU CONTRASEÑA: ");
								contrasena1 = sc.nextLine();
								
								
								if(gestionUsuario.buscarNombreUsuario(nomUsuario) && gestionUsuario.buscarcontrasena(contrasena1)) {
									
									System.out.print("Ingrese su RTN:");
									rtn1 = sc.nextLine();
									
									int posicionusuarioBuscado = gestionUsuario.buscarUsuarioPosicion(rtn1);
									
									if (posicionusuarioBuscado == -1) {
										System.out.println("Usuario no encontrado.\n");
									}else {
										
										Usuario UsuarioEncontrado = gestionUsuario.getUsuarioPorPosicion(posicionusuarioBuscado);
										System.out.println("Nombre de usuario actual: " + UsuarioEncontrado.get_nombreUsuario());
										System.out.println("Contraseña actual: " + UsuarioEncontrado.get_contrasena());

										//NOMBRE DE USUARIO Y CONSTRASEÑA
										boolean centinelaUsuario = true, centinelaContraseña = true;
										String usuario = "", usuarioConfir = "",constrasena = "", constrasenaconfirm = "";
										
										//CREAR NOMBRE DE USUARIO
										while(centinelaUsuario) {
											System.out.print("NUEVO NOMBRE DE USUARIO: ");
											usuario = sc.nextLine();
											
											System.out.println("CONFORMAR NUEVO NOMBRE DE USUARIO: ");
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
										
										Usuario UsuarioModificado = new Usuario(UsuarioEncontrado.get_codigoUsuario(),UsuarioEncontrado.get_fechaRegistro(),
												UsuarioEncontrado.get_nombre(),UsuarioEncontrado.get_apellido(),UsuarioEncontrado.get_fechaNacimiento(),
												UsuarioEncontrado.get_direccion(),UsuarioEncontrado.get_telefono(),UsuarioEncontrado.get_rtn(),
												UsuarioEncontrado.get_correoelectronico(), usuario, constrasena, UsuarioEncontrado.get_referencia());
										
										if(gestionUsuario.ModificarUsuario(UsuarioModificado, posicionusuarioBuscado)) {
											System.out.println("Usuario modificado con exito.\n");
											System.out.println(UsuarioModificado);
										}else {
											System.out.println("Error al modificar Usuario.\n");
										}
										
									}
								}else {
									System.out.println("Usuario y contraseña incorrecto o Usuario no registrado.");
									break;
								}
								
							break;
						case 2: //SALIR.
							
							
							break;
							default:
								System.out.println("OPCIÓN NO VALIDA.");
								break;
						}
				
					
				break;
			case 4: //ELIMINAR TIPO DE CUENTA.
				break;
			case 5: //ELIMINAR USUARIO.
				break;
			case 6: //MODIFICAR USUARIO.
				break;
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