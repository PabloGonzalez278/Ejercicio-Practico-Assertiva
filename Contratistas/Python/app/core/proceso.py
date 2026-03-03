from app.services.user_service import get_users
from app.services.contratistaTransformer import transform
from app.services.exportCSV import export_csv
from app.config import settings

def run_process():
    users = get_users()
    filas = transform(users, settings.domain)
    export_csv(filas)
    return f"{len(filas)} registros exportados correctamente"