INSERT INTO resumen_transacciones (id, fecha, monto, tipo, es_anomalia) VALUES ('TRX-001', '2023-01-01', 1500.0, 'DEPOSITO', false);
INSERT INTO resumen_transacciones (id, fecha, monto, tipo, es_anomalia) VALUES ('TRX-002', '2023-01-02', 500.0, 'RETIRO', false);
INSERT INTO resumen_transacciones (id, fecha, monto, tipo, es_anomalia) VALUES ('TRX-003', '2023-01-03', -100.0, 'RETIRO', true);

INSERT INTO intereses_mensuales (cuenta_id, nombre, saldo, edad, tipo, saldo_final) VALUES ('CTA-1001', 'Juan Perez', 5000.0, '35', 'AHORRO', 5025.0);
INSERT INTO intereses_mensuales (cuenta_id, nombre, saldo, edad, tipo, saldo_final) VALUES ('CTA-1002', 'Maria Lopez', 2000.0, '28', 'CORRIENTE', 2000.0);

INSERT INTO transacciones_anuales (cuenta_id, fecha, transaccion, monto, descripcion) VALUES ('CTA-1001', '2023-01-05', 'DEPOSITO', 1000.0, 'Sueldo');
INSERT INTO transacciones_anuales (cuenta_id, fecha, transaccion, monto, descripcion) VALUES ('CTA-1001', '2023-01-10', 'RETIRO', 200.0, 'Cajero');
-- BCrypt password for 'password' is $2a10
INSERT INTO usuarios (username, password, role) VALUES ('userweb', '$2a$10$r/x0c7g7/FhUf.eT9wK28eZ00rXk5n.U/W5x9.x/28q.X/T08FhX2', 'ROLE_WEB');
INSERT INTO usuarios (username, password, role) VALUES ('usermobile', '$2a$10$r/x0c7g7/FhUf.eT9wK28eZ00rXk5n.U/W5x9.x/28q.X/T08FhX2', 'ROLE_MOBILE');
INSERT INTO usuarios (username, password, role) VALUES ('useratm', '$2a$10$r/x0c7g7/FhUf.eT9wK28eZ00rXk5n.U/W5x9.x/28q.X/T08FhX2', 'ROLE_ATM');
