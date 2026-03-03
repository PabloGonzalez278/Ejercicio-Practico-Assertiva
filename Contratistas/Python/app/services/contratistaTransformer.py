from app.models import CSVContratista
from app.services.correoContratista import CorreoContratista

generator = CorreoContratista()

def transform(users, domain):
    filas = []

    for user in users:
        correo = generator.next_corporate_email(user.name, domain)

        filas.append(
            CSVContratista(
                nombre=user.name,
                telefono=user.phone,
                correo=user.email,
                empresa=user.company.name,
                ciudad=user.address.city,
                correo_corporativo=correo
            )
        )

    return filas