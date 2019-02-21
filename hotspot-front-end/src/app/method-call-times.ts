import { Method } from './method';
import { MethodCall } from './method-call';

export class MethodCallTimes {
    methodMap: {methodId: number, method: Method};
    methodCalls: MethodCall[];
}
