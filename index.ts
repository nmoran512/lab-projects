// A relation is reflexive if and only if there is an ordered pair (a,a) in the set r1 for every element (a) in A.

// declaring and initializing set A, every element in this set must be represented in (a,a) fashion (such that a is an element in the set A)
const setA: number[] = [1, 2, 3, 4]
// relation represented in a multidimensional array
const m = new Map<number, number[]>([
  [1, [1, 2]],
  [2, [2, 3]],
  [3, [1, 4]]
  
]);

// function isReflexive will compare each element of the multidimensional array
// and if the relation is represented as (a,a) (such that a is an element in the setA)
// it is reflexive. All elements in setA must be represented in (a,a) within the relation
function isReflexive(setA: number[], m: Map<number, number[]>): boolean {
  let result: boolean = false
  for (const element of setA){
    result = false;
    for (const pair of m.values()) {
      const a = pair[0] || 0;
      const b = pair[1] || 0;

      if( a === element && b === element){
        result = true
      }

    }
    if(result === false)
      return false

  }
  return true
}
function isIrreflexive(setA: number[], m: Map<number, number[]>): boolean {
  for(const element of setA){
    for(const pair of m.values()){
      const a = pair[0] || 0
      const b = pair[1] || 0

      if(a === element && b === element){
        return false
      }
    }
  }
  return true
}
function isSymmetric (setA: number[], m: Map<number, number[]>): boolean {
  let result: boolean = false
  for (const element of setA){
    result = false
    for(const pair of m.values()){
      const a = pair[0] || 0
      const b = pair[1] || 0
      for(const pair of m.values()){
        const c = pair[0] || 0
        const d = pair[1] || 0
        if(a === d && b ===c){
          result = true
      }

      }
      if(!result){
        return false
      }
    }
  }
  return true
}
// function isAntiSymmetric checks a relation off of a set to see if these conditions are met:
// if for all a,b in the relation there are no instances of b,a in the same relation
//then a == b
function isAntiSymmetric(setA: number[], m: Map<number, number[]>): boolean {
  for(const element of setA){
    for(const pair of m.values()){
      const a = pair[0]
      const b = pair[1]
      if(a !== b){
        for(const pair of m.values()){
          const c = pair[0]
          const d = pair[1]
          if(a == d && b == c){
            return false
          }
        }
      } else return true
    }
   }
  return true
}
function isTransitive(setA: number[], m: Map<number, number[]>): boolean {
  let result: boolean = false
    for(const pair of m.values()) { 
      const a = pair[0]
      const b = pair[1]
      for(const pair of m.values()){
        if(result) {
          break
        }
        const c = pair[0]
        const d = pair[1]

        if(b === c){
          for(const pair of m.values()){
            const e = pair[0]
            const f = pair[1]
            if(a === e && d === f){
              result = true
            }
            if(result) break
            
          }
        }
      }
    }
  return result
}


const reflexiveness = isReflexive(setA, m)
console.log('\nIs this relation reflexive off of set A: ' + reflexiveness + 
            '\nIs the relation irreflexive off of set A: ' + isIrreflexive(setA, m) +
            '\nIs the relation symmetric?: ' + isSymmetric(setA, m) + 
            '\nIs the relation antisymmetric?: ' + isAntiSymmetric(setA, m) + 
            '\nIs the relation transitive? : ' + isTransitive(setA, m))
