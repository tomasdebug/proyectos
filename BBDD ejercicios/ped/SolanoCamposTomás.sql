
# Fichero para la solución del Caso Práctico de "Bases de datos". 

# Modifíquelo para incluir el codigo necesario para llevar a cabo los pasos necesarios para
# resolver los distintos apartados. Debe incluir comentarios con explicaciones del código
# propuesto.


-- Si existe, borrar la base de datos Cadena_hotelera:

DROP DATABASE IF EXISTS Cadena_hotelera;

-- Crear la base de datos Cadena_hotelera:

CREATE DATABASE IF NOT EXISTS Cadena_hotelera;

-- Usar la base de datos Cadena_hotelera: 

USE Cadena_hotelera;


#################################################################################################
#    Crear el esquema de la base de datos con las tablas que se extraen del diagrama E-R 
#    presentado y del propio enunciado del problema.
#################################################################################################
# Apartado 1: Crear la tabla Hoteles
#################################################################################################

create table Hoteles(
CodHotel varchar(10),
Nombre varchar(30) ,
Direccion varchar(50) ,
Ciudad varchar(30) ,
FecInaug date,
Categoria decimal(1,0),
NumHabitac decimal(3,0),
PRIMARY KEY(CodHotel)

);

#################################################################################################
# Apartado 2: Crear la tabla Clientes
#################################################################################################

create table Clientes(
NIF varchar(9),
nombre varchar(30) ,
Apellido1 varchar(30) ,
Apellido2 varchar(30) ,
FecNacim date,
Direccion varchar(50),
ciudad varchar(30),
PRIMARY KEY(NIF)

);

#################################################################################################
# Apartado 3: Crear la tabla Reservas
#################################################################################################

create table Reservas(
CodReserva varchar(10),
CodHotel varchar(10) ,
NIF varchar(9) ,
FechaEntrada date,
FechaReserva date,
NumNoches decimal(3,0),
NumHabitac decimal(3,0),
NumAdultos decimal(3,0),
NumNinyos decimal(4,0),
PrecioNochHab decimal(6,2),
PRIMARY KEY(CodReserva),
FOREIGN KEY (CodHotel) REFERENCES Hoteles(CodHotel),
FOREIGN KEY (NIF) REFERENCES Clientes(NIF)
);

################################################################################################
# Poblar las tres tablas creadas con los datos proporcionados en "Cadena Hotelera - Datos.sql" 
# y también listados a continuación.
#################################################################################################

INSERT INTO Hoteles (CodHotel, Nombre, Direccion, Ciudad, FecInaug, Categoria, NumHabitac) VALUES
('H001', 'Hotel Sol', '123 Calle Sol', 'Madrid', '2000-05-20', 4, 100),
('H002', 'Hotel Luna', '456 Calle Luna', 'Barcelona', '2010-06-15', 5, 150),
('H003', 'Hotel Estrella', '789 Calle Estrella', 'Valencia', '2015-03-30', 3, 50),
('H004', 'Hotel Cometa', '321 Calle Cometa', 'Sevilla', '2020-01-22', 2, 30),
('H005', 'Hotel Galaxia', '654 Calle Galaxia', 'Madrid', '2005-12-05', 4, 80);

INSERT INTO Clientes (NIF, Nombre, Apellido1, Apellido2, FecNacim, Direccion, Ciudad) VALUES
('12345678A', 'Ana', 'García', 'López', '1985-04-15', '111 Avda Prado', 'Madrid'),
('87654321B', 'Luis', 'Martín', 'Santos', '1972-08-25', '222 Avda Olmos', 'Barcelona'),
('11223344C', 'Carmen', 'Ruiz', 'Diaz', '1990-01-10', '333 Avda Mar', 'Valencia'),
('44332211D', 'Jorge', 'Fernández', 'Moreno', '1965-07-20', '444 Avda Sierra', 'Sevilla'),
('55667788E', 'Laura', 'Torres', 'Nieto', '1979-12-30', '555 Avda Sol', 'Madrid'),
('23456789F', 'Sofía', 'Pérez', 'Gómez', '1993-03-22', '666 Avda Júpiter', 'Madrid'),
('34567890G', 'Carlos', 'Jiménez', 'Fernández', '1980-11-11', '777 Avda Saturno', 'Barcelona'),
('45678901H', 'Marta', 'López', 'Martínez', '1976-02-05', '888 Avda Neptuno', 'Valencia'),
('56789012I', 'Antonio', 'García', 'Romero', '1964-09-09', '999 Avda Urano', 'Sevilla'),
('67890123J', 'Beatriz', 'Vega', 'Prieto', '1989-12-16', '1010 Avda Plutón', 'Madrid');

INSERT INTO Reservas (CodReserva, CodHotel, NIF, FechaEntrada, FechaReserva, NumNoches, NumHabitac, NumAdultos, NumNinyos, PrecioNochHab) VALUES
('R001', 'H001', '12345678A', '2023-04-01', '2023-03-20', 3, 2, 2, 1, 100.00),
('R002', 'H002', '87654321B', '2023-04-15', '2023-03-25', 5, 1, 2, 2, 150.00),
('R003', 'H003', '11223344C', '2023-05-10', '2023-04-20', 2, 3, 1, 0, 90.00),
('R004', 'H004', '44332211D', '2022-12-25', '2022-11-30', 7, 1, 2, 3, 60.00),
('R005', 'H001', '55667788E', '2023-04-20', '2023-03-15', 4, 1, 1, 0, 120.00),
('R006', 'H005', '12345678A', '2023-04-25', '2023-04-10', 3, 1, 2, 2, 110.00),
('R007', 'H001', '11223344C', '2023-03-15', '2023-02-20', 5, 2, 1, 1, 110.00),
('R008', 'H002', '44332211D', '2023-06-05', '2023-05-20', 3, 1, 2, 0, 160.00),
('R009', 'H003', '12345678A', '2022-12-10', '2022-11-25', 4, 3, 2, 2, 85.00),
('R010', 'H004', '87654321B', '2022-11-15', '2022-10-30', 2, 1, 2, 1, 70.00),
('R011', 'H005', '55667788E', '2023-07-01', '2023-06-15', 6, 2, 2, 3, 95.00),
('R012', 'H001', '11223344C', '2023-08-20', '2023-07-25', 7, 1, 1, 0, 100.00),
('R013', 'H002', '44332211D', '2023-09-05', '2023-08-01', 10, 2, 2, 2, 180.00),
('R014', 'H003', '12345678A', '2022-07-25', '2022-07-10', 5, 2, 2, 0, 75.00),
('R015', 'H004', '55667788E', '2023-12-25', '2023-12-01', 14, 1, 2, 2, 65.00),
('R016', 'H005', '44332211D', '2023-10-10', '2023-09-20', 3, 1, 1, 1, 105.00),
('R017', 'H002', '87654321B', '2023-01-15', '2022-12-20', 8, 3, 3, 0, 140.00),
('R018', 'H001', '11223344C', '2023-11-01', '2023-10-10', 4, 1, 1, 0, 130.00),
('R019', 'H003', '12345678A', '2023-02-10', '2023-01-15', 3, 1, 2, 1, 90.00),
('R020', 'H004', '44332211D', '2023-05-20', '2023-04-25', 6, 2, 2, 3, 80.00),
('R021', 'H001', '23456789F', '2024-01-05', '2023-12-20', 4, 1, 2, 1, 100.00),
('R022', 'H002', '34567890G', '2024-02-15', '2024-01-30', 3, 2, 2, 0, 160.00),
('R023', 'H003', '45678901H', '2024-03-10', '2024-02-20', 7, 1, 1, 2, 85.00),
('R024', 'H004', '56789012I', '2024-04-20', '2024-03-25', 5, 1, 2, 3, 70.00),
('R025', 'H005', '67890123J', '2024-05-01', '2024-04-15', 6, 2, 2, 2, 95.00),
('R026', 'H001', '23456789F', '2024-06-25', '2024-06-10', 3, 1, 1, 0, 120.00),
('R027', 'H002', '34567890G', '2024-07-15', '2024-06-30', 8, 1, 2, 1, 150.00),
('R028', 'H003', '45678901H', '2024-08-05', '2024-07-20', 2, 3, 2, 0, 90.00),
('R029', 'H004', '56789012I', '2024-09-10', '2024-08-25', 10, 2, 2, 2, 80.00),
('R030', 'H005', '67890123J', '2024-10-20', '2024-09-30', 14, 1, 1, 1, 105.00),
('R031', 'H002', '34567890G', '2024-11-15', '2024-10-31', 5, 2, 3, 0, 140.00),
('R032', 'H001', '23456789F', '2024-12-10', '2024-11-25', 7, 1, 2, 1, 130.00),
('R033', 'H001', '23456789F', '2024-05-10', '2024-04-14', 5, 1, 2, 1, 110.00),
('R034', 'H002', '34567890G', '2024-06-15', '2024-04-13', 3, 2, 2, 0, 160.00),
('R035', 'H003', '45678901H', '2024-07-20', '2024-04-12', 7, 1, 1, 2, 85.00),
('R036', 'H004', '56789012I', '2024-08-05', '2024-04-11', 5, 1, 2, 3, 70.00),
('R037', 'H005', '67890123J', '2024-05-25', '2024-04-10', 6, 2, 2, 2, 95.00),
('R038', 'H001', '23456789F', '2024-06-30', '2024-04-09', 3, 1, 1, 0, 120.00),
('R039', 'H002', '34567890G', '2024-07-15', '2024-04-08', 8, 1, 2, 1, 150.00),
('R040', 'H003', '45678901H', '2024-08-25', '2024-04-07', 2, 3, 2, 0, 90.00),
('R041', 'H004', '56789012I', '2024-05-05', '2024-04-06', 10, 2, 2, 2, 80.00),
('R042', 'H005', '67890123J', '2024-06-20', '2024-04-05', 14, 1, 1, 1, 105.00),
('R043', 'H002', '34567890G', '2024-07-30', '2024-04-04', 5, 2, 3, 0, 140.00),
('R044', 'H001', '23456789F', '2024-08-10', '2024-04-03', 7, 1, 2, 1, 130.00);


################################################################################################# 
# Apartado 4: CONSULTA Listar Hoteles de Alta Categoría

# Esta consulta selecciona todos los hoteles que tienen una categoría de 4 o 5, mostrando el
# CodHotel, nombre, ciudad y categoría. 
#################################################################################################

select CodHotel, Nombre, Ciudad ,Categoria
from Hoteles
where Categoria >3;




################################################################################################# 
# Apartado 5: CONSULTA Contar Clientes por Ciudad

# Esta consulta cuenta cuántos clientes hay de cada ciudad, ordenados de forma descendente según
# ese número, lo cual es útil para entender la distribución geográfica de la clientela.
#################################################################################################

select *
from(
select Ciudad, COUNT(Nombre) AS numero_clientes
 from Clientes 
 group by Ciudad)
 as clientesciudad(Ciudad,numero_clientes) order by numero_clientes DESC;




################################################################################################# 
# Apartado 6: CONSULTA Detalle de las ocupaciones de los próximos 30 días

# Esta consulta recupera detalles de las reservas realizadas para entrar en los próximos 30 días, 
# incluyendo el código de la reserva, el código del hotel, la fecha de reserva, la fecha de 
# entrada, y el número de noches. El resultado ordenado por fecha de entrada ascendente.
#################################################################################################

select CodReserva,CodHotel,FechaReserva,FechaEntrada,NumNoches 
from Reservas
where FechaEntrada > current_date and FechaEntrada < DATE_ADD(current_date, INTERVAL 30 DAY) 
order by FechaEntrada ;



################################################################################################# 
# Apartado 7: CONSULTA Ingresos futuros por hotel

# Calcular los ingresos futuros esperados de cada hotel basados en las reservas que aún no han 
# comenzado, utilizando el número de habitaciones reservadas, número de noches y el precio por noche.
##################################################################################################




select H.Nombre,sum(R.PrecioNochHab * R.NumHabitac * R.NumNoches) as Dinerofuturo,R.CodHotel
 from Hoteles as H,Reservas as R
 where H.CodHotel=R.CodHotel and R.FechaEntrada > curdate()
 group by H.Nombre,R.CodHotel;
 
 

################################################################################################# 
# Apartado 8: CONSULTA Clientes frecuentes por ciudad (3 o más reservas)

# Identificar los clientes que han realizado tres o más reservas en hoteles de una misma ciudad.
# Lista el nombre y apellido1 del cliente, la ciudad de los hoteles y el número total de reservas
# en hoteles de esa ciudad.
#################################################################################################
select C.Nombre,C.Apellido1,count(*) as totalReservas,H.Ciudad
from Reservas as R,Clientes as C ,Hoteles as H
where R.NIF = C.NIF and H.CodHotel = R.CodHotel
group by C.Nombre,C.Apellido1,H.Ciudad
having count(*) >= 3;





################################################################################################# 
# Apartado 9: CONSULTA Reservas para entrar en un hotel en el mismo mes de su inauguración

# Listar todas las reservas cuya entrada coincide con el mes de aniversario de la inauguración 
# del hotel, mostrando el nombre del hotel, fecha de inauguraración, nombre del cliente 
# y la fecha de entrada. El mes de la fecha de entrada tiene que coincidir con el mes de la
# fecha de inauguración.
#################################################################################################
select H.nombre,H.FecInaug,C.nombre,R.FechaEntrada
from Reservas as R,Hoteles as H,Clientes as C
where month(FecInaug) = month(FechaEntrada) and C.NIF=R.NIF and H.CodHotel =R.CodHotel;




################################################################################################# 
# Apartado 10: CONSULTA Listado hoteles con meses de alta ocupación en 2023

#  Listar los hoteles que tuvieron una ocupación de más del 2% en cualquier mes de 2023 
#  mostrando nombre del hotel, año, mes y el porcentaje de ocupación. El porcentaje
#  de ocupación en un mes se calcula como el número de habitaciones reservadas dividido por el
#  numero de habitaciones del hotel * 100. 
# Se pide un dato tan pequeño de ocupación porque hay dadas de altas pocas reservas
#################################################################################################


with numeroHabitacionesocupadasxmes as 
(select H.nombre as nombreHotel,month(FechaEntrada) as numeromes,count(R.NIF) as numeroreservas,H.NumHabitac as numeroHabitaciones
from Reservas as R,Hoteles as H,Clientes as C
where year(FechaEntrada)= 2023 and R.CodHotel=H.CodHotel and C.NIF=R.NIF
group  by numeromes,nombreHotel,numeroHabitaciones)
select nombreHotel,numeromes,numeroreservas, 100*numeroreservas/numeroHabitaciones as porcentajeOcupacion
from numeroHabitacionesocupadasxmes
where 100*numeroreservas/numeroHabitaciones > 2;





################################################################################################# 
# Apartado 11: CONSULTA Clientes sin reservas recientes

#  Encontrar clientes que no hayan hecho ninguna reserva en el último año. Mostrar nombre y apellido1
#################################################################################################

select  distinct nombre,apellido1,R.NIF
from Reservas as R,Clientes as C
where  FechaReserva <= Date_sub(current_date(),interval 1 year)  and C.NIF=R.NIF;





################################################################################################# 
# Apartado 12: CONSULTA Listado de hoteles y coste medio de habitación

#  Listado de todos los hoteles con el nombre, categoria y precio medio de la habitación. 
#  Ordenar por el precio medio descendente.
#################################################################################################


select h.Nombre as NombreHotel, h.Categoria, avg(r.PrecioNochHab) as PrecioMedioHabitacion
from Hoteles h
left join Reservas r on h.CodHotel = r.CodHotel
group by  h.Nombre, h.Categoria
order by PrecioMedioHabitacion desc;



################################################################################################# 
# Apartado 13: VISTA VistaDetalleReservas con toda la información clave de las reservas

/*
Tablas Involucradas:
   Reservas: Contiene todos los detalles de las reservas hechas por los clientes.
   Hoteles: Incluye información sobre los hoteles donde se realizan las reservas.
   Clientes: Almacena datos sobre los clientes que han hecho las reservas.

Campos de la vista:

   CodReserva: El código identificador de la reserva.
   HotelNombre: El nombre del hotel asociado a la reserva.
   HotelCiudad: La ciudad donde está ubicado el hotel.
   ClienteNombre: El nombre del cliente que realizó la reserva.
   ClienteApellido1: El primer apellido del cliente.
   FechaEntrada: La fecha en la que el cliente tiene previsto iniciar su estancia.
   NumNoches: Número de noches que el cliente se hospedará en el hotel.
   NumHabitac: Número de habitaciones reservadas.
   NumAdultos: Número de adultos incluidos en la reserva.
   NumNinyos: Número de niños incluidos en la reserva.
   PrecioNochHab: Precio por noche y por habitación.
*/

#################################################################################################

create view VistaDetalleReservas as
select R.CodReserva,H.Nombre as nombreHotel,H.Ciudad ,C.nombre as NombreCliente,C.Apellido1,R.FechaEntrada,R.NumNoches,R.NumHabitac,R.NumAdultos,R.NumNinyos,R.PrecioNochHab
from reservas as R,hoteles as H,clientes as C
where R.CodHotel=H.CodHotel and C.NIF=R.NIF;
#SELECT * FROM VistaDetalleReservas;


################################################################################################# 
# Apartado 14: CONSULTA Reservas realizadas en los últimos 30 días

#  Utilizar la vista VistaDetalleReservas para realizar una consulta que encuentre todas las 
#  reservas con entrada en los próximos 30 días. Mostrar todos los campos de la vista.
#################################################################################################

select *
from VistaDetalleReservas
where FechaEntrada > current_date and FechaEntrada < date_add(current_date,interval 30 day);

################################################################################################# 
# Apartado 15: FUNCION CostoReserva() que calcule el costo de una reserva

/*
Crear la función CostoReserva() que tome como entrada el código de una reserva (CodReserva) y 
devuelva el costo de esa reserva específica. La función calculará el costo total de la reserva 
multiplicando el número de noches, el número de habitaciones y el precio por noche por habitación, 
todo a partir del código de reserva proporcionado.
*/

#################################################################################################

DELIMITER //
create function CostoReserva(CodReserva varchar(10))
returns integer
deterministic
reads sql data 
begin 
    declare resultado integer;
    
    select NumNoches * NumHabitac * PrecioNochHab into resultado
    from reservas 
    where reservas.CodReserva = CodReserva;
    
    return resultado;
end//
DELIMITER ;
select CostoReserva("R001") as costoreserva;	
################################################################################################# 
# Apartado 16: CONSULTA Costo medio de las reservas de cada cliente

/*
Empleando en la consulta la función CostoReserva() creada en el apartado anterior, listar 
el nombre de todos los clientes, el numero de reservas  que ha hecho y el costo medio de 
las reservas que ha hecho y el costo total de las reservas hechas.
*/
#################################################################################################


select C.nombre,count(distinct R.CodReserva) as numeroReservasDistintas,avg((select CostoReserva(R.CodReserva))) as mediaReservas,sum((select CostoReserva(R.CodReserva))) as costetotal
from clientes as C,reservas as R
where C.NIF = R.NIF
group by C.nombre;
    





