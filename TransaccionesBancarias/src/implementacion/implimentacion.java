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
		
		GestionReferencia gestionRefencia = new GestionReferencia();
		GestionUsuario gestionUsuario = new GestionUsuario();
		GestionCuentaAhorro gestionCuentaAhorro = new GestionCuentaAhorro();
		GestionCuentaCheques gestionCuentaCheques = new GestionCuentaCheques();
		GestionCuentaCorrientePersonal gestionCuenCorrienteper = new GestionCuentaCorrientePersonal();
		GestionCuentaNomina gestionCuentaNomina = new GestionCuentaNomina();
		
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
				Usuario usuario1 = new Usuario();
				
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
							System.out.print("Nombres:");
							nombre = sc.nextLine();
							System.out.print("Apellidos:");
							apellido = sc.nextLine();
							System.out.println("Fecha de nacimiento: (dd-MM-yyyy)");
							fechaNacimiento = sc.nextLine();
							Date FechaNacimientoUsuario = AdminFechas.stringToDate(fechaNacimiento);
							System.out.print("Dirección:");
							direccion = sc.nextLine();
							System.out.print("Telefono:");
							telefono = sc.nextLine();
							System.out.print("RTN:");
							rtn = sc.nextLine();
							System.out.print("Correo electronico:");
							correoElectronico = sc.nextLine();
							
							//NOMBRE DE USUARIO Y CONSTRASEÑA
							boolean centinelaUsuario = true, centinelaContraseña = true;
							String usuario = "", usuarioConfir = "",constrasena = "", constrasenaconfirm = "";
							
							//CREAR NOMBRE DE USUARIO
							System.out.println("\nCREE NOMBRE DE USUARIO Y CONTRASEÑA.\n");
							while(centinelaUsuario) {
								System.out.println("Usuario: ");
								usuario = sc.nextLine();
								
								System.out.println("Confirmar Usuario: ");
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
								System.out.println("Contraseña: ");
								constrasena = sc.nextLine();
								
								System.out.println("Confirmar contraseña: ");
								constrasenaconfirm = sc.nextLine();
								
								if(gestionUsuario.confirmar(constrasena, constrasenaconfirm)) {
									System.out.println("Contraseña creada con exito");
									centinelaContraseña = false;
								}else {
									System.out.println("Las constraseñas no coinciden.");
								}
							}//FIN DE CODIGO PARA CREAR CONTRASEÑA
							
							
							usuario1.set_codigoUsuario(CodUsuario);
							usuario1.set_nombre(nombre);
							usuario1.set_apellido(apellido);
							usuario1.set_direccion(direccion);
							usuario1.set_fechaNacimiento(FechaNacimientoUsuario);
							usuario1.set_fechaRegistro(AdminFechas.getFechaActual());
							usuario1.set_telefono(telefono);
							usuario1.set_rtn(rtn);
							usuario1.set_correoelectronico(correoElectronico);
							usuario1.set_contrasena(constrasena);
							usuario1.set_nombreUsuario(usuario);
							
							if(gestionUsuario.AgregarUsuario(usuario1)) {
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
								System.out.println("Fecha de nacimiento: (dd-MM-yyyy)");
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
											
											if(gestionUsuario.buscarUsuarioPosicion(usuario1.get_rtn()) != -1 ) {
											
												System.out.println("APERTURA DE CUENTA DE AHORRO\n");
												System.out.println("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												interesRemunerado = gestionCuentaAhorro.InteresRemunerado(montoInicial);
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaAhorro cuentaAhorro1 = new CuentaAhorro(AdminFechas.getFechaActual(),"CUENTA DE AHORRO", NumCuenta,
														montoInicial, interesRemunerado);
												
												if(gestionCuentaAhorro.AgregarCuentaAhorro(cuentaAhorro1)) {
													if(usuario1.AgregarCuentaBancaria(cuentaAhorro1)) {
														System.out.println("CUENTA DE AHORRO CREADA EXITOSAMENTE.\n");
													}
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
											
											if(gestionUsuario.buscarUsuarioPosicion(usuario1.get_rtn()) != -1 ) {
												
												System.out.println("APERTURA DE CUENTA DE CHEQUES\n");
												System.out.println("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												interesRemunerado = gestionCuentaCheques.InteresRemunerados(montoInicial);
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaCheques cuentachques1 = new CuentaCheques(AdminFechas.getFechaActual(),"CUENTA DE CHEQUES", 
														NumCuenta, montoInicial, interesRemunerado);
												
												if(gestionCuentaCheques.AgregarCuentaCheques(cuentachques1)) {
													if(usuario1.AgregarCuentaBancaria(cuentachques1)) {
														System.out.println("CUENTA DE CHEQUES CREADA EXITOSAMENTE.\n");
													}
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
											if(gestionUsuario.buscarUsuarioPosicion(usuario1.get_rtn()) != -1) {
												
												System.out.println("APERTURA DE CUENTA CORRIENTE PERSONAL\n");
												System.out.println("Monto inicial: ");
												montoInicial = scnum.nextDouble();
												
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaCorrientePersonal cuentaCorrientepers1 = new CuentaCorrientePersonal(AdminFechas.getFechaActual(),
														"CUENTA CORRIENTE PERSONALA", NumCuenta, montoInicial);
												
												if(gestionCuenCorrienteper.AgregarCuentaCorrientePersonal(cuentaCorrientepers1)) {
													if(usuario1.AgregarCuentaBancaria(cuentaCorrientepers1)) {
														System.out.println("CUENTA CORRIENTE PERSONAL CREADA EXITOSAMENTE.\n");
													}
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
											if(gestionUsuario.buscarUsuarioPosicion(usuario1.get_rtn()) != -1) {
												
												System.out.println("APERTURA DE CUENTA DE NOMINA\n");
												System.out.println("Ingrese la empresa depositante:");
												empresa = sc.nextLine();
												NumCuenta = gestionUsuario.GeneraNumeroCuenta();
												System.out.println("Su número de cuenta es:" + NumCuenta + "\n");
											
												CuentaNomina cuentaNomina1 = new CuentaNomina(AdminFechas.getFechaActual(), "CUENTA DE NOMINA", 
														NumCuenta, 0, empresa);
												
												if(gestionCuentaNomina.AgregarCuentaNomina(cuentaNomina1)) {
													if(usuario1.AgregarCuentaBancaria(cuentaNomina1)){
														System.out.println("CUENTA DE NOMINA CREADA EXITOSAMENTE.\n");
													}
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
				
				if(gestionUsuario.AgregarUsuario(usuario1)) {
					System.out.println("ERROR AL REGISTRAR USUARIO\n");
				}else {
					System.out.println("USUARIO REGISTRADO CORRECTAMENTE./n");
				}
				
				//gestionUsuario.imprimirTodos();
				System.out.println(usuario1);
				
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
										break;
									case 2: //RETIRAR
										break;
									case 3: // CONSULTAR SALDO
										break;
									case 4: //TRANSFERENCIAS
										break;
									case 5: //PAGO DE SERVICIOS PUBLICOS
										break;
									case 6: //SALIR
										centinenlamenutrasn = false;
										break;
										default:
											System.out.println("Opcion no valida.");
											break;
									}//fin del swicth
									System.out.println("¿Desea realizar otra Transacción?\n1. SI\n2.NO");
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
												UsuarioEncontrado.get_correoelectronico(), usuario, constrasena, UsuarioEncontrado.get_listaCuentasBancarias());
										
										if(gestionUsuario.ModificarUsuario(UsuarioModificado, posicionusuarioBuscado)) {
											System.out.println("Usuario modificado con exito.\n");
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
	}

}