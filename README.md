# Implementación de un sistema de monitoreo de transacciones financieras en tiempo real

En un entorno de banca digital, el sistema debe procesar y monitorear transacciones financieras en tiempo real provenientes de múltiples canales (web, móvil, cajeros automáticos). Cada transacción tiene un identificador único, monto, fecha y hora de ocurrencia, y estado (pendiente, procesada, rechazada). El sistema debe ser resiliente ante fallos temporales de los canales de entrada, escalable para manejar picos de tráfico y confiable en la persistencia y notificación de las transacciones.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Programación Reactiva |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: Un IDE o editor de código.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Verifica que el proyecto arranca sin errores.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del sistema de entrada de transacciones

**Objetivo:** Establecer un canal de entrada operativo que persista transacciones con idempotencia.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- El sistema debe aceptar transacciones desde los tres canales declarados.
- Cada transacción debe persistir con un identificador único que garantice la idempotencia.
- El sistema debe devolver la misma respuesta ante reintentos con la misma clave de idempotencia dentro de 24 horas.

**Entregable:** Canal de entrada operativo persistiendo transacciones con idempotencia.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar la concurrencia y la idempotencia en la persistencia de datos.
- Piensa en cómo el sistema puede recuperarse de fallos temporales en los canales de entrada.

</details>

### Fase 2: Consolidación de transacciones de múltiples canales

**Objetivo:** Integrar los tres canales de entrada sin pérdida de transacciones ante backpressure de uno de ellos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- El sistema debe consolidar transacciones de los tres canales sin pérdida, incluso si uno de ellos experimenta backpressure.
- Debe garantizar que cada transacción se procese una sola vez, independientemente del canal de origen.

**Entregable:** Sistema que consolida transacciones de los tres canales sin pérdida ante backpressure.

<details>
<summary>Pistas de conocimiento</summary>

- Explora cómo los operadores de Project Reactor pueden ayudarte a manejar backpressure y consolidar flujos de eventos.
- Considera el uso de buffering y estrategias de reintento para garantizar la entrega de todas las transacciones.

</details>

### Fase 3: Recuperación automática ante caídas del consumidor downstream

**Objetivo:** Implementar recuperación automática ante caídas del sistema que consume las transacciones.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- El sistema debe recuperarse automáticamente ante caídas del consumidor downstream sin reprocesar transacciones ya emitidas.
- Debe emitir un evento al sistema de auditoría por cada transacción aceptada.

**Entregable:** Sistema con recuperación automática ante caídas del consumidor downstream y emisión de eventos de auditoría.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga cómo los operadores de Project Reactor pueden ayudarte a implementar recuperación automática y emisión de eventos.
- Considera el uso de retry y circuit breaker para manejar caídas del consumidor downstream.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los operadores de Project Reactor y cómo se usan para manejar flujos de eventos?
- **comoSeUsa**: ¿Cómo usarías los operadores de Project Reactor para garantizar la idempotencia y la resiliencia del sistema?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar programación reactiva y cómo los evitarías?
- **queDecisionesImplica**: ¿Qué decisiones de diseño implica la implementación de un sistema reactivo resiliente y escalable?

## Criterios de Evaluacion

- Implementación de un canal de entrada operativo con idempotencia.
- Consolidación de transacciones de múltiples canales sin pérdida ante backpressure.
- Recuperación automática ante caídas del consumidor downstream sin reprocesar transacciones ya emitidas.
- Emisión de eventos de auditoría por cada transacción aceptada.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
