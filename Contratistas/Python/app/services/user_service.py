import requests
from app.models import User
from app.config import settings

def get_users():
    response = requests.get(settings.endpoint)
    response.raise_for_status()
    data = response.json()
    return [User(**u) for u in data]