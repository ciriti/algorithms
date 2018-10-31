# Application Fundamentals

The Android operating system is a **multi-user Linux system** in which each
app is a different user.

By default, the system assigns each app a unique Linux **user ID**.
The system sets permissions for all the files in an app so that only
the user ID assigned to that app can access them.

Every app runs in its own **Linux process**. The Android system starts the
process when any of the app's components need to be executed, and then
shuts down the process when it's no longer needed or when the system
must recover memory for other apps

**PRINCIPLE OF LEAST PRIVILEGE**: each app, by default, has access only
to the components that it requires to do its work and no more.

There are four different types of app components:

- **Activities**: entry point for interacting with the user, it
represents a single screen od the phone

- **Services**: general-purpose entry point for keeping an app running
in the background, like the activity but without layout.

**Started service**: A service is started when an application component,
such as an activity, starts it by calling startService().
Once started, a service can run in the background indefinitely,
even if the component that started it is destroyed.

**Bound service**: A service is bound when an application component binds
to it by calling bindService(). A bound service offers a client-server
interface that allows components to interact with the service,
send requests, get results, and even do so across processes with
interprocess communication (IPC).

![Service lifecycle](https://i.stack.imgur.com/xLycD.jpg)

- **Broadcast receivers**: A broadcast receiver is a component that
enables the system to deliver events to the app outside of a regular
user flow, allowing the app to respond to system-wide broadcast
announcements.

- **Content providers**: component used to share data.

**INTENT**: It is an object which defines a message to activate a specific
component (EXPLICIT INTENT) or a specific type of component (IMPLICIT INTENT).

Component of an Intent:

- Component name
- Action
- Data
- Category
- Extras
- Flags

Component name: The name of the component to start can be null and you
have an implicit intent

Action: A string that specifies the generic action to perform (such as view or pick)

Data: the URI and/or MIME type

Category:  kind of component that should handle the intent

Extras: Key-value pairs that carry additional information required to
accomplish the requested action

Flags: The flags may instruct the Android system how to launch an
activity (for example, which task the activity should belong to)
and how to treat it after it's launched (for example, whether it belongs
in the list of recent activities).

# Processes and Application Lifecycle

Android places each process into an "importance hierarchy" based on the
components running in them and the state of those components.
These process types are (in order of importance):

1. foreground process
2. visible process
3. service process
4. cached process

FOREGROUND PROCESS: for instance when an activity at the top of the
screen and the user is interacting with.

VISIBLE PROCESS: when an activity is in pause.

SERVICE PROCESS: when a **started service** is started.

CACHED PROCESS: is one that is not currently needed.