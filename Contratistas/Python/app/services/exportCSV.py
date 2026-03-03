import csv
from pathlib import Path
from app.config import settings

def export_csv(filas):
    path = Path(settings.output_csv)
    path.parent.mkdir(parents=True, exist_ok=True)

    with open(path, mode="w", newline="", encoding="utf-8") as file:
        writer = csv.writer(file)
        writer.writerow(["Nombre", "Telefono", "Correo", "Empresa", "Ciudad", "Correo Corporativo"])

        for fila in filas:
            writer.writerow([
                fila.nombre,
                fila.telefono,
                fila.correo,
                fila.empresa,
                fila.ciudad,
                fila.correo_corporativo
            ])