import unicodedata

class CorreoContratista:

    def __init__(self):
        self.generated = {}

    def normalize(self, text):
        text = unicodedata.normalize("NFD", text)
        text = text.encode("ascii", "ignore").decode("utf-8")
        return text.lower()

    def next_corporate_email(self, full_name, domain):
        parts = full_name.strip().split()
        if len(parts) < 2:
            raise ValueError("Nombre inválido o incorrecto")

        first = self.normalize(parts[0][0])
        last = self.normalize(parts[-1])

        base = f"{first}{last}"

        count = self.generated.get(base, 0)
        self.generated[base] = count + 1

        suffix = "" if count == 0 else str(count)
        return f"{base}{suffix}@{domain}"